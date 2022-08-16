package com.displate.javaenabling.springworkshop.context.app4configimport;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Predicate;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
class SomeClass {
    Predicate<String> validator;

    boolean doStuff(String input) {
        if (validator.test(input)) {
            log.info("String is valid");
            return true;
        } else {
            log.warn("String is invalid");
            return false;
        }
    }
}
