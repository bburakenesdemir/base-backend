package com.burakenesdemir.basebackend.service;

import com.burakenesdemir.basebackend.exception.UnAuthorizedException;
import com.burakenesdemir.basebackend.model.mongo.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtTokenServiceImpl implements JwtTokenService {
    private String jwtTokenValidity;

    private String secretKey;

    public JwtTokenServiceImpl(Environment environment) {
        this.jwtTokenValidity = environment.getProperty("com.burakenesdemir.jwt-token-validity");
        this.secretKey = environment.getProperty("com.burakenesdemir.secret-key");
    }

    @Override
    public String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, user.getUsername());
    }

    @Override
    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);

        if (expiration.before(new Date())) {
            throw new UnAuthorizedException("Token is expired!");
        }else{
            return false;
        }
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parserBuilder().requireAudience(secretKey).build().parseClaimsJws(token).getBody();
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        Key key = Keys.hmacShaKeyFor(keyBytes);

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(jwtTokenValidity) * 1000)).signWith(key).compact();
    }

}
