package com.harshitbhardwaj.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.logging.Logger;

@Component
public class AuthenticationLoggingFilter extends OncePerRequestFilter {

    private final Logger logger = Logger.getLogger(AuthenticationLoggingFilter.class.getName());

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String authorizationHeader = request.getHeader("Authorization");

        // Log the authentication key (Authorization header) if it exists
        if (authorizationHeader != null) {
            logger.info("Authentication key used: " + authorizationHeader);
        } else {
            logger.info("No Authentication key found in the request.");
        }
        filterChain.doFilter(request, response);
    }
}
