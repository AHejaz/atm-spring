package com.brehon.week_10_practice_java_atm_spring.util;

import com.brehon.week_10_practice_java_atm_spring.entity.Account;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class JwtUtils {

    @Value(value = "${jwt.secret.key}")
    private String secretKey;

    @Value(value = "${jwt.expireOnMs.key}")
    private String expireKey;

    private Claims getAllClaimsFromToken(String token){
       return Jwts.parser().setSigningKey(secretKey).parseClaimsJwt(token).getBody();
    }

    private Date getExpiredDate(String token){
       return getAllClaimsFromToken(token).getExpiration();
    }

    private Boolean isTokenExpired(String token){
        return getExpiredDate(token).before(new Date());
    }

    public   Boolean validateToken(String token){
        try {
            String jwtToken = Optional.ofNullable(token)
                    .map(String::trim)
                    .orElseThrow();
            if (isTokenExpired(token))
                return false;
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public String generateToken(Account account){
        Map<String,Object> claims = new HashMap<>();
        claims.put("ac_num",account.getAccountNumber());
        claims.put("uid",account.getUser().getId());
        return generateToken(claims,account.getUser().getNationalCode());
    }

    private String generateToken(Map<String,Object>claims,String subject){
        return Jwts.builder().setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expireKey))
                .signWith(SignatureAlgorithm.HS512,secretKey).compact();
    }
}
