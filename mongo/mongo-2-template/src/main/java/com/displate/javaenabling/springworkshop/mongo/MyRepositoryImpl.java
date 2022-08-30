package com.displate.javaenabling.springworkshop.mongo;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

class MyRepositoryImpl implements MyRepository {

    private final MongoTemplate mongoTemplate;

    MyRepositoryImpl(MongoTemplate mongoTemplate) {
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
    public Optional<MyDocument> findBySomeValue(BigDecimal someValue) {
        return Optional.ofNullable(mongoTemplate.findOne(
                Query.query(Criteria.where("someValue").is(someValue)),
                MyDocument.class
        ));
    }

    @Override
    public List<MyDocument> findBySomeObjectsText(String text) {
        return mongoTemplate.find(Query.query(
                        Criteria.where("someObjects")
                                .elemMatch(Criteria.where("text").is(text))),
                MyDocument.class);
    }
}
