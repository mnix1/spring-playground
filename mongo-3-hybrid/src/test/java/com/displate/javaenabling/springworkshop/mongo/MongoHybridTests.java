package com.displate.javaenabling.springworkshop.mongo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Clock;
import java.time.Instant;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class MongoHybridTests extends MongoTest {
    @Autowired
    TaskRepository repository;

    @Autowired
    Clock clock;

    @BeforeEach
    void setup() {
        repository.save(new MyEnqueuedTask("id1", "", getEpochSecond("2007-12-09T10:15:30.00Z")));
        repository.save(new MyEnqueuedTask("id2", "", getEpochSecond("2008-12-09T10:15:30.00Z")));
        repository.save(new MyEnqueuedTask("id3", "", getEpochSecond("2009-12-09T10:15:30.00Z")));
        repository.save(new MyEnqueuedTask("id4", "", getEpochSecond("2010-12-09T10:15:30.00Z")));
    }

    @Test
    void correctlyTakesEnqueuedTasks() {
        MyEnqueuedTask taskBefore = repository.findById("id1").get();

        Optional<MyEnqueuedTask> myEnqueuedTask = repository.takeNextForProcessing();
        assertEquals("id1", myEnqueuedTask.get().id());

        MyEnqueuedTask taskAfter = repository.findById("id1").get();
        assertTrue(hasLaterLastAttempt(taskAfter, taskBefore));
    }

    private boolean hasLaterLastAttempt(MyEnqueuedTask taskAfter, MyEnqueuedTask taskBefore) {
        return taskAfter.lastAttemptInstant().isAfter(taskBefore.lastAttemptInstant());
    }

    private long getEpochSecond(String dateString) {
        return Instant.parse(dateString).getEpochSecond();
    }

}
