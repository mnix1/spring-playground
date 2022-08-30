package com.displate.javaenabling.springworkshop.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Clock;

@SpringBootApplication
public class MongoApplication {

    @Bean
    Clock clock() {
        return Clock.systemDefaultZone();
    }

    public static void main(String[] args) {
        SpringApplication.run(MongoApplication.class, args);
    }

}
