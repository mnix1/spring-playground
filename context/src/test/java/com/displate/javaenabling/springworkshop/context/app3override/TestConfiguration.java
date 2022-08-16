package com.displate.javaenabling.springworkshop.context.app3override;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

class TestConfiguration {

    @Bean
    @Primary
    UserRepository repository() {
        UserRepository result = new UserRepository();
        result.save(new User("Drake", "Canada"));
        return result;
    }

}
