package com.displate.javaenabling.springworkshop.context.app2configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
class MyConfiguration {

    @Bean
    @Profile("integration")
    UserRepository userRepository() {
        return new UserRepository();
    }
}
