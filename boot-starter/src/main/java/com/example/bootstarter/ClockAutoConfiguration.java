package com.example.bootstarter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;
import java.time.ZoneId;

@Configuration
class ClockAutoConfiguration {

    @Bean
    Clock clock() {
        return Clock.system(ZoneId.of("Poland"));
    }
}
