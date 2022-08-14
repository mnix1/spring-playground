package com.example.bootstarter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class RolesAutoConfiguration {

    @Bean
    RoleClient roles() {
        return new RoleClient();
    }
}
