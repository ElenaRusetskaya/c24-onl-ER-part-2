package by.teachmeskills.lesson40.config;

import by.teachmeskills.lesson40.service.UserPrincipal;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class JwtHelper {
    private static final String TOKEN_CLAIM = "token";
    private static final String PRIVILEGE_CLAIM = "privilege";

    private static final String SOURCE_CLAIM = "source";

    private static final JWSHeader JWT_HEADER = new JWSHeader(JWSAlgorithm.HS256);

    private final JWSSigner jwtSigner;
    private final JWSVerifier jwsVerifier;
    private final Duration expiration;
    private final UserDetailsService userDetailsService;

    public JwtHelper(UserDetailsService userDetailsService,
                     @Value("${jwt.secret}") String secret,
                     @Value("${jwt.expiration}") Duration expiration) throws JOSEException {
        this.userDetailsService = userDetailsService;
        this.jwtSigner = new MACSigner(secret);
        this.jwsVerifier = new MACVerifier(secret);
        this.expiration = expiration;
    }
    @SneakyThrows
    public String generateToken(String issuer, @Nullable String xSource, UserPrincipal userInfo) {
        final Pair<Date, Date> issueAndExpirationTimes = getIssueAndExpirationTimes();
        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .issuer(issuer)
                .subject(userInfo.getUsername())
                .claim(TOKEN_CLAIM, UUID.randomUUID().toString())
                .claim(PRIVILEGE_CLAIM, userInfo.getAuthorities())
                .claim(SOURCE_CLAIM, Objects.toString(xSource, ""))
                .issueTime(issueAndExpirationTimes.getLeft())
                .expirationTime(issueAndExpirationTimes.getRight())
                .build();
        SignedJWT signedJWT = new SignedJWT(JWT_HEADER, claimsSet);
        signedJWT.sign(jwtSigner);
        return signedJWT.serialize();
    }
    @SneakyThrows
    public String generateToken(String issuer, @Nullable String xSource, Authentication userInfo) {
        final Pair<Date, Date> issueAndExpirationTimes = getIssueAndExpirationTimes();
        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .issuer(issuer)
                .subject(userInfo.getName())
                .claim(TOKEN_CLAIM, UUID.randomUUID().toString())
                .claim(PRIVILEGE_CLAIM, userInfo.getAuthorities())
                .claim(SOURCE_CLAIM, Objects.toString(xSource, ""))
                .issueTime(issueAndExpirationTimes.getLeft())
                .expirationTime(issueAndExpirationTimes.getRight())
                .build();

        SignedJWT signedJWT = new SignedJWT(JWT_HEADER, claimsSet);
        signedJWT.sign(jwtSigner);
        return signedJWT.serialize();
    }
    @Nullable
    public UserPrincipal getTokenClaims(String token) throws JOSEException {
        final JWTClaimsSet jwtClaims;
        try {
            final SignedJWT decodedJWT = SignedJWT.parse(token);
            if (decodedJWT.verify(jwsVerifier) && isValid(jwtClaims = decodedJWT.getJWTClaimsSet())) {
                String userName = decodedJWT.getJWTClaimsSet().getSubject();
                return (UserPrincipal) userDetailsService.loadUserByUsername(userName);
            }
        } catch (ParseException pe) {
            log.error("Invalid token {}", token, pe);
        }
        return null;
    }
    @SuppressWarnings("unchecked")
    private <T> Optional<T> getClaim(JWTClaimsSet jwtClaims, String claim) {
        return Optional.ofNullable((T) jwtClaims.getClaim(claim));
    }
    private Pair<Date, Date> getIssueAndExpirationTimes() {
        Instant issuedAt = Instant.now().truncatedTo(ChronoUnit.MILLIS);
        Instant expirationAt = issuedAt.plus(expiration);
        return Pair.of(Date.from(issuedAt), Date.from(expirationAt));
    }
    public boolean isValid(JWTClaimsSet jwtClaims) {
        Date referenceTime = new Date();
        Date expirationTime = jwtClaims.getExpirationTime();
        Date notBeforeTime = jwtClaims.getNotBeforeTime();
        boolean expired = expirationTime != null && expirationTime.before(referenceTime);
        boolean yetValid = notBeforeTime == null || notBeforeTime.before(referenceTime);
        return !expired && yetValid;
    }
}