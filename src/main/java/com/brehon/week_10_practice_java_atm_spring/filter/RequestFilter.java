package com.brehon.week_10_practice_java_atm_spring.filter;

import com.brehon.week_10_practice_java_atm_spring.util.JwtUtils;
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

    public RequestFilter(JwtUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (!jwtUtils.validateToken(token)){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }else {
            filterChain.doFilter(request,response);
        }

    }
}
