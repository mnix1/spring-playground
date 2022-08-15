package com.example.mvcboot.filter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@ConditionalOnProperty(value = "app.filter", havingValue = "true")
@Order(value = 9)
class BlockFilter implements Filter {
    private final LoggingService loggingService;

    BlockFilter(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        loggingService.log("BlockFilter doFilter");
        if (request instanceof HttpServletRequest) {
            String header = ((HttpServletRequest) request).getHeader("BLOCK");
            if (header != null) {
                if(response instanceof HttpServletResponse){
                    ((HttpServletResponse) response).setStatus(401);
                }
                return;
            }
        }
        chain.doFilter(request, response);
    }

}