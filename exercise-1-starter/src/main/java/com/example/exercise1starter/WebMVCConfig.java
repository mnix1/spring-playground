package com.example.exercise1starter;

import com.example.bootstarter.RoleService;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

class WebMVCConfig implements WebMvcConfigurer {
    private final RoleService roleService;

    WebMVCConfig(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthorizationInterceptor(roleService));
    }
}
