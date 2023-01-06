package com.degreeproject.IENP.security;

import com.degreeproject.IENP.constant.SecurityConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtGenerator {
    public String generateToken(Authentication authentication) {
        String username = authentication.getName();
        Date currentDate = new Date();
        Date expiryDate = new Date(currentDate.getTime()+ SecurityConstant.EXPIRY_DATE);

        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(currentDate)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS256, SecurityConstant.SECRET)
                .compact();
        return token;
    }

    public String getUsernameFromToken(String token){
        Claims claims = Jwts.parser().setSigningKey(SecurityConstant.SECRET).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    public Boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(SecurityConstant.SECRET).parseClaimsJws(token).getBody();
            return true;
        }catch (Exception e){
            throw new AuthenticationCredentialsNotFoundException("Token Expired or Incorrect");
        }
    }
}
