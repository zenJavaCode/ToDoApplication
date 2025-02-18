package com.codeRoots.ToDoApplication.service;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.util.Date;

public class JwtService {

    private static final String SECRET_KEY = "fasdjfhsadjhfakdshffjhdasjkfhksfjknfjkhdsk";
    private static final long ACCESS_TOKEN_EXPIRATION = 86400000;
    private static final long REFRESH_TOKEN_EXPIRATION = 161400000;

    // generate Token
    public String generateToken(String username, boolean isAccessToken) {

        long expiration = isAccessToken ? ACCESS_TOKEN_EXPIRATION : REFRESH_TOKEN_EXPIRATION;

        return Jwts.builder().
                setSubject(username).
                setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()), SignatureAlgorithm.HS256).compact();
    }

    //get name from token
    public String getUsernameFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(SECRET_KEY.getBytes()).build().parseClaimsJws(token).getBody().getSubject();
    }

    // validate token
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(SECRET_KEY.getBytes()).build().parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            e.printStackTrace();
            return false;
        }

    }

    //


}
