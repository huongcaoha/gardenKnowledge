package com.ra.session01.security.jwt;


import com.ra.session01.security.principle.StudentPrinciple;
import io.jsonwebtoken.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class JWTProvider {
    @Value("${jwt_expired}")
    private long expired ;
    Logger logger = LoggerFactory.getLogger(JWTEntrypoint.class);
    @Value("${jwt_secret}")
    private String secret;
    public String generateToken(StudentPrinciple studentPrinciple){
      Date exp = new Date(new Date().getTime()+ expired);
     return Jwts.builder()
              .setSubject(studentPrinciple.getUsername())
              .setExpiration(exp)
              .signWith(SignatureAlgorithm.HS512, secret)
              .compact();
    }

    public Boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true ;
        }catch (ExpressionException | SignatureException | ExpiredJwtException | MalformedJwtException ex){
            logger.error("Exception Authentication {}", ex.getMessage());
        }
        return false ;
    }

    public String getUsernameFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

}
