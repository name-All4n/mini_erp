package com.my_project.mini_ERP.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.my_project.mini_ERP.model.user.User;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create().withIssuer("mini-ERP")
                    .withSubject(user.getLogin())
                    .withExpiresAt(generateExpirationDate())
                    .sign(algorithm);
        }catch(JWTCreationException exception){
            throw new RuntimeException("erro ao generar JWT",  exception);
        }
    }

    private Instant generateExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

    public String validationToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("mini-ERP")
                    .build().verify(token)
                    .getSubject();
        }catch(JWTCreationException exception){
            return "";
        }
    }
}
