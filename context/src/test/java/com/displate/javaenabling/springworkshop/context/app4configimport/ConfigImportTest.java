package com.displate.javaenabling.springworkshop.context.app4configimport;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ConfigImportTest {

    @Autowired
    SomeClass someClass;

    @Test
    void shouldReturnTrueForNonEmptyString() {
        assertTrue(someClass.doStuff("sth"));
    }

    @Test
    void shouldReturnFalseForEmptyString() {
        assertFalse(someClass.doStuff(""));
    }
}
