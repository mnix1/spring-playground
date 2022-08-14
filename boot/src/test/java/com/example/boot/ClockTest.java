package com.example.boot;

import com.example.bootstartertest.StubClock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Clock;
import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ClockTest {

    @Autowired
    StubClock stubClock;
    @Autowired
    Clock clock;

    @BeforeEach
    void setUp() {
        stubClock.set(Instant.parse("2000-01-03T00:23:11Z"));
    }

    @Test
    void returnsFixedTimestamp() {
        assertThat(Instant.now(stubClock)).isEqualTo(Instant.parse("2000-01-03T00:23:11Z"));
    }

    @Test
    void clockSameAsStubClock() {
        assertThat(clock).isEqualTo(stubClock);
    }
}
