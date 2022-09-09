package com.example.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringSecurityApplication {

    public static void main(String[] args) {
       args = Stream.concat(
                Arrays.stream(args),
                Stream.of("--spring.profiles.active=local")
        ).toArray(String[]::new);
        SpringApplication.run(SpringSecurityApplication.class, args);
    }
}
