package com.example.bootstartertest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
class ClockAutoConfiguration {
    //TODO czemu pokazuje warning? jak to zafixować?
    @Bean
    @Primary
    //TODO co się stanie jak się usunie @Primary?
    StubClock stubClock() {
        return new StubClock();
    }
}
