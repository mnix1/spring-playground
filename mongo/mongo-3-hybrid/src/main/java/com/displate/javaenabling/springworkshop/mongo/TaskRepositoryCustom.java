package com.displate.javaenabling.springworkshop.mongo;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.time.Clock;
import java.util.Optional;

interface TaskRepositoryCustom {

    Optional<MyEnqueuedTask> takeNextForProcessing();

}

class TaskRepositoryCustomImpl implements TaskRepositoryCustom {

    private final MongoTemplate mongoTemplate;
    private final Clock clock;

    TaskRepositoryCustomImpl(MongoTemplate mongoTemplate, Clock clock) {
        this.mongoTemplate = mongoTemplate;
        this.clock = clock;
    }

    @Override
    public Optional<MyEnqueuedTask> takeNextForProcessing() {

        Query query = new Query().with(Sort.by(Sort.Direction.ASC, "lastAttempt"));

        return Optional.ofNullable(
                mongoTemplate.findAndModify(query,
                        Update.update("lastAttempt", clock.instant().getEpochSecond()),
                        MyEnqueuedTask.class
                )
        );
    }
}