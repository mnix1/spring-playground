package com.displate.javaenabling.springworkshop.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document
record MyEnqueuedTask(@Id String id,
                      String payload,
                      Long lastAttempt) {

    Instant lastAttemptInstant() {
        return Instant.ofEpochSecond(lastAttempt);
    }
}