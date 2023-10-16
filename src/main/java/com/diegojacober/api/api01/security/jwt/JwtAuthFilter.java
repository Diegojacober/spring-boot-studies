package com.diegojacober.api.api01.security.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.diegojacober.api.api01.service.impl.UserServiceImpl;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthFilter extends OncePerRequestFilter{

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserServiceImpl userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

            String authorization = request.getHeader("Authorization");

            if(authorization != null && authorization.startsWith("Bearer")) {
                String token = authorization.split(" ")[1];
                boolean isValid = jwtService.tokenValido(token);

                if(isValid) {
                    String userLogin = jwtService.obterLoginUsuario(token);
                    UserDetails user = userService.loadUserByUsername(userLogin);
                    UsernamePasswordAuthenticationToken userAuthenticated = new UsernamePasswordAuthenticationToken(user, user.getAuthorities());
                    userAuthenticated.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(userAuthenticated);
                }
            }

            filterChain.doFilter(request, response);
    }
    
}
