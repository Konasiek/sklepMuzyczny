package com.sklepmuzyczny.demo.jwt;

import com.sklepmuzyczny.demo.model.User;
import com.sklepmuzyczny.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String jwt = getToken(httpServletRequest);
        if (jwt != null && jwtProvider.validate(jwt)) {
            try {
                String username = jwtProvider.getUserAccount(jwt);
                Optional<User> user = userService.findOne(username);
                // pwd not necessary
                // if jwt ok, then authenticate
                // tu moze byc cos zle
                SimpleGrantedAuthority sga = new SimpleGrantedAuthority(user.get().getRoles().toString());
                Set<SimpleGrantedAuthority> sgaSet = new HashSet<>();
                sgaSet.add(sga);

                UsernamePasswordAuthenticationToken auth
                        = new UsernamePasswordAuthenticationToken(user.get().getUsername(), null, sgaSet);
                SecurityContextHolder.getContext().setAuthentication(auth);

            } catch (Exception e) {
                logger.error("Set Authentication from JWT failed");
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private String getToken(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.replace("Bearer ", "");
        }

        return null;
    }
}
