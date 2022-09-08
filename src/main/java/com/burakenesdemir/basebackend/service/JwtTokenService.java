package com.burakenesdemir.basebackend.service;

import com.burakenesdemir.basebackend.model.mongo.User;

public interface JwtTokenService {
    String generateToken(User user);

    String getUsernameFromToken(String token);

    Boolean isTokenExpired(String token);
    }
