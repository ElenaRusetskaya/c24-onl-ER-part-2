package by.teachmeskills.lesson40.config.security;

import by.teachmeskills.lesson40.config.JwtHelper;
import by.teachmeskills.lesson40.service.UserPrincipal;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.thymeleaf.util.StringUtils;

import static by.teachmeskills.lesson40.controller.AuthController.AUTH_REQUEST_MAPPING;
@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private static final String BEARER_ = "Bearer ";

    private final JwtHelper jwtHelper;

    @Override
    @SneakyThrows
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {
        if (request.getRequestURI().startsWith(AUTH_REQUEST_MAPPING)) {
            filterChain.doFilter(request, response);
            return;
        }
        String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (StringUtils.isEmpty(header) || !header.startsWith(BEARER_)) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return;
        }
        String jwt = header.substring(BEARER_.length()).trim();
        UserPrincipal userPrincipal = jwtHelper.getTokenClaims(jwt);
        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken(
                        userPrincipal.getUsername(),
                        userPrincipal.getPassword(),
                        userPrincipal.getAuthorities()));
        filterChain.doFilter(request, response);
    }
}
