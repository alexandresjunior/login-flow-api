package com.login.flow.api.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.login.flow.api.model.Usuario;

@Service
public class TokenService {

    public String generateToken(Usuario usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);

            return JWT.create()
                    .withIssuer(TOKEN_ISSUER)
                    .withSubject(usuario.getEmail())
                    .withExpiresAt(_expirationDate())
                    .withClaim("id", usuario.getIdUsuario())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            // Invalid Signing configuration / Couldn't convert Claims.
            throw new RuntimeException("Erro ao gerar token JWT.", exception);
        }
    }

    public String getSubject(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);

            return JWT.require(algorithm)
                .withIssuer(TOKEN_ISSUER)
                .build()
                .verify(token)
                .getSubject();
        } catch (JWTVerificationException exception){
            // Invalid signature/claims
            throw new RuntimeException("Token JWT inválido ou expirado.", exception);
        }
    }

    private Instant _expirationDate() {
        // O token expira em 2min de acordo com o fuso horário do Brasil
        return LocalDateTime.now().plusMinutes(2).toInstant(ZoneOffset.of("-03:00"));
    }

    // Propriedades definida no application.properties

    @Value("${api.security.token.secret.key}")
    private String SECRET_KEY;

    @Value("${api.security.token.issuer}")
    private String TOKEN_ISSUER;

}
