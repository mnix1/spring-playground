package com.example.bootstartertest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
class ClockAutoConfiguration {

    @Bean
    @Primary
    StubClock stubClock() {
        return new StubClock();
    }
}
