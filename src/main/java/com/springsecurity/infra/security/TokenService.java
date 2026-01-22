package com.springsecurity.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.springsecurity.infra.config.JwtProperties;
import com.springsecurity.models.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final JwtProperties jwtProperties;

    public String generateToken(User user) {
        Algorithm algorithm = Algorithm.HMAC256(jwtProperties.privateKey());

        return JWT.create()
                .withIssuer("Spring Security")
                .withSubject(user.getUsername())
                .withExpiresAt(generateExpirationDate())
                .sign(algorithm);
    }

    public String validateToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(jwtProperties.privateKey());

        return JWT.require(algorithm)
                .withIssuer("Spring Security")
                .build()
                .verify(token)
                .getSubject();
    }

    private Instant generateExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
