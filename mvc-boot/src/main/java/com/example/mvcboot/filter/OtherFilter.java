package com.example.mvcboot.filter;

import com.example.mvcboot.LoggingService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@ConditionalOnProperty(value = "app.filter", havingValue = "true")
//TODO change order
@Order(value = 10)
class OtherFilter extends OncePerRequestFilter {
    private final LoggingService loggingService;

    OtherFilter(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        StringBuffer url = request.getRequestURL();
        loggingService.log("OtherFilter doFilterInternal " + url);
        filterChain.doFilter(request, response);
    }
}