package com.displate.javaenabling.springworkshop.mongo.common;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Optional;

public class MyRepositoryImpl implements MyRepository {

    private final MongoOperations mongoTemplate;

    public MyRepositoryImpl(MongoOperations mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public MyDocument save(MyDocument entity) {
        return mongoTemplate.save(entity);
    }

    @Override
    public Optional<MyDocument> findById(String id) {
        return Optional.ofNullable(mongoTemplate.findById(id, MyDocument.class));
    }

    @Override
    public boolean existsById(String id) {
        return mongoTemplate.exists(
                Query.query(Criteria.where("id").is(id)),
                MyDocument.class
        );
    }
}
