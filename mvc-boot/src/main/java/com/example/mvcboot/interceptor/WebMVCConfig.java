package com.example.mvcboot.interceptor;

import com.example.mvcboot.LoggingService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ConditionalOnProperty(value = "app.interceptor", havingValue = "true")
class WebMVCConfig implements WebMvcConfigurer {
    private final LoggingService loggingService;

    public WebMVCConfig(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new BlockInterceptor(loggingService));
    }
}
