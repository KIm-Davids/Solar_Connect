package com.semicolon.africa.adapters.configuration.filter;

import com.semicolon.africa.adapters.configuration.JWTService;
import com.semicolon.africa.adapters.services.AdminServices;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTFilter extends OncePerRequestFilter {


    @Autowired
    private JWTService jwtService;

    @Autowired
    private ApplicationContext context;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // Extract the Authorization header
        String authHeader = request.getHeader("Authorization");

        // Initialize token as null
        String token = null;

        // Check if the Authorization header is not null and starts with "Bearer "
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            // Extract the token by removing the "Bearer " prefix
            token = authHeader.substring(7); // "Bearer " is 7 characters long
        }

        // If token is valid, extract the username
        if (token != null) {
            String username = jwtService.extractUserName(token);  // Extract username from the token

            // Only proceed if the user is not already authenticated
            if (SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = context.getBean(AdminServices.class).loadUserByUsername(username);

                // Validate the token and set the authentication if valid
                if (jwtService.validateToken(token, userDetails)) {
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }

        // Continue with the filter chain
        filterChain.doFilter(request, response);
    }

}
