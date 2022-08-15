package com.example.bootstarter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class RolesAutoConfiguration {

    @Bean
    RoleClient roleClient() {
        return new RoleClient();
    }

    @Bean
    RoleService roleService() {
        return new RoleService();
    }
}
