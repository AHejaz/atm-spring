package com.brehon.week_10_practice_java_atm_spring.filter;

import com.brehon.week_10_practice_java_atm_spring.config.ApiUrlProperties;
import com.brehon.week_10_practice_java_atm_spring.config.SharedUserContext;
import com.brehon.week_10_practice_java_atm_spring.util.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class RequestFilter extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;

    private final ApiUrlProperties apiUrlProperties;


    private  SharedUserContext sharedUserContext;

    public RequestFilter(JwtUtils jwtUtils, ApiUrlProperties apiUrlProperties, SharedUserContext sharedUserContext) {
        this.jwtUtils = jwtUtils;
        this.apiUrlProperties = apiUrlProperties;
        this.sharedUserContext = sharedUserContext;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (apiUrlProperties.getPublicUrl().contains(request.getRequestURI()) ) {
            filterChain.doFilter(request, response);

        } else if (jwtUtils.validateToken(token)) {

            Claims claims = jwtUtils.getAllClaimsFromToken(token);
            sharedUserContext.setUserId((Long) claims.get("uId"));
            sharedUserContext.setAccountNumber(claims.get("ac_num").toString());
            sharedUserContext.setNationalCode(claims.getSubject());
            filterChain.doFilter(request, response);

        }else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }

    }
}
