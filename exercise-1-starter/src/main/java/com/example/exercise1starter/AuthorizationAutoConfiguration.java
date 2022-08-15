package com.example.exercise1starter;

import com.example.bootstarter.RoleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class AuthorizationAutoConfiguration {

    @Bean
    AuthenticationFilter blockFilter() {
        return new AuthenticationFilter();
    }

    @Bean
    WebMVCConfig webMVCConfig(RoleService roleService) {
        return new WebMVCConfig(roleService);
    }
}
