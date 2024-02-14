package by.teachmeskills.lesson40.service;

import by.teachmeskills.lesson40.entity.UserJwt;
import by.teachmeskills.lesson40.entity.type.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@RequiredArgsConstructor
public class UserPrincipal implements UserDetails {

    private final UserJwt userJwt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(userJwt.getRole().getName()));
    }
    @Override
    public String getPassword() {
        return userJwt.getPassword();
    }
    @Override
    public String getUsername() {
        return userJwt.getLogin();
    }
    @Override
    public boolean isAccountNonExpired() {
        return !Status.LOGIN_EXPIRED.equals(userJwt.getStatus());
    }
    @Override
    public boolean isAccountNonLocked() {
        return !Status.BLOCKED.equals(userJwt.getStatus());
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return !Status.PASSWORD_EXPIRED.equals(userJwt.getStatus());
    }
    @Override
    public boolean isEnabled() {
        return Status.OK.equals(userJwt.getStatus());
    }
}
