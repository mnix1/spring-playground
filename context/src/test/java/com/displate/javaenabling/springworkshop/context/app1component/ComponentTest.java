package com.displate.javaenabling.springworkshop.context.app1component;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ComponentTest {

    public static final User DRAKE = new User("Drake", "Canada");
    @Autowired
    UserRepository repository;

    @Test
    void shouldSaveUser() {
        repository.save(DRAKE);

        assertEquals(DRAKE, repository.findByUserName("Drake"));
    }

}
