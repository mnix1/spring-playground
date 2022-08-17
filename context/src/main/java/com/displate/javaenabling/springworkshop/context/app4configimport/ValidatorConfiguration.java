package com.displate.javaenabling.springworkshop.context.app4configimport;

import org.springframework.context.annotation.Bean;

import java.util.function.Predicate;

class ValidatorConfiguration {
    @Bean
    Predicate<String> isEmptyValidator() {
        return s -> !s.isEmpty();
    }

}
