package com.displate.javaenabling.springworkshop.context.app4configimport;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Predicate;

@Configuration
@EnableValidator
class MyConfiguration {
    @Bean
    SomeClass someClass(Predicate<String> validator) {
        return new SomeClass(validator);
    }
}
