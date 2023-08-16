package com.digitalocean.digitalocean.config;

import java.io.IOException;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestSecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;

        // Set allowed methods
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");

        // Set allowed origin(s)
        String allowedOrigin = "*"; // Change this to restrict to specific origins
        response.setHeader("Access-Control-Allow-Origin", allowedOrigin);

        // Set credentials allowed (if required)
        response.setHeader("Access-Control-Allow-Credentials", "true");

        // Set allowed headers
        String allowedHeaders = "Authorization, Content-Type"; // Add any other headers you want to allow
        response.setHeader("Access-Control-Allow-Headers", allowedHeaders);

        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            // For pre-flight OPTIONS requests, set status to OK and return
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            // For other requests, continue the filter chain
            chain.doFilter(req, res);
        }
    }
}
