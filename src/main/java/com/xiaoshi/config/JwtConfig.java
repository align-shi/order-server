package com.xiaoshi.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.xiaoshi.domain.User;
import org.springframework.stereotype.Component;

@Component
public class JwtConfig {

    public String getToken(User user) {
        String token = "";
        token = JWT.create().withAudience(String.valueOf(user.getId()))
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
