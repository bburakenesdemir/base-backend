package com.burakenesdemir.basebackend.configuration;

import com.burakenesdemir.basebackend.model.mongo.User;
import com.burakenesdemir.basebackend.model.type.RoleEnum;
import com.burakenesdemir.basebackend.service.JwtTokenService;
import com.burakenesdemir.basebackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ApiJwtAuthorizationFilter extends OncePerRequestFilter {

    private final JwtTokenService jwtTokenService;

    private final UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (!isContainsBearerPrefix(getToken(request)) || isTokenExpired(request)) {
            filterChain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);

    }

    private boolean isContainsBearerPrefix(String text) {
        return text != null && text.startsWith("Bearer");
    }

    private boolean isTokenExpired(HttpServletRequest request) {
        return jwtTokenService.isTokenExpired(getToken(request));
    }

    private String getToken(HttpServletRequest req) {
        return req.getHeader("Authorization");
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = getToken(request);
        String username = jwtTokenService.getUsernameFromToken(token);
        User user = userService.getByUsername(username);
        RoleEnum role = user.getRole();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        return new UsernamePasswordAuthenticationToken(username, user, authorities);
    }

}
