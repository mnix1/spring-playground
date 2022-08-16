package com.displate.javaenabling.springworkshop.context.app3override;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class OverrideTest {

    public static final User DRAKE = new User("Drake", "Canada");
    @Autowired
    UserRepository repository;

    @Test
    void shouldSaveUser() {
        assertEquals(DRAKE, repository.findByUserName("Drake"));
    }

}
