package com.displate.javaenabling.springworkshop.context.app2configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class MyConfiguration {

    @Bean
    UserRepository userRepository() {
        return new UserRepository();
    }
}
