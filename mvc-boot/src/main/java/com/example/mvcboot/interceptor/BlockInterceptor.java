package com.example.mvcboot.interceptor;

import com.example.mvcboot.LoggingService;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class BlockInterceptor implements HandlerInterceptor {
    private final LoggingService loggingService;

    BlockInterceptor(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        boolean pass = request.getHeader("Block") == null;
        loggingService.log("BlockInterceptor preHandle handler=" + handler + " pass=" + pass);
        if (!pass) {
            response.setStatus(403);
        }
        return pass;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
        loggingService.log("BlockInterceptor postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        loggingService.log("BlockInterceptor afterCompletion");
    }

}