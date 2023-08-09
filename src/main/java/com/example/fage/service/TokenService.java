package com.example.fage.service;

import com.example.fage.entity.Pessoa;
import org.springframework.stereotype.Service;

import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.JWT;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {

    public String generateToken(Pessoa pessoa) {
        return JWT.create()
                .withIssuer("")
                .withSubject(pessoa.getDocumento())
                .withClaim("id", pessoa.getId())
                .withExpiresAt(Date.from(LocalDateTime.now()
                        .plusMinutes(15)
                        .toInstant(ZoneOffset.of("-03:00")))
                ).sign(Algorithm.HMAC256("venustemvida"));
    }

}
