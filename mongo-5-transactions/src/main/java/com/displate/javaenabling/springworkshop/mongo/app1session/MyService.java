package com.displate.javaenabling.springworkshop.mongo.app1session;

import com.displate.javaenabling.springworkshop.mongo.common.MyDocument;
import com.displate.javaenabling.springworkshop.mongo.common.MyNestedObject;
import com.mongodb.ClientSessionOptions;
import com.mongodb.ReadConcern;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import org.springframework.data.mongodb.core.MongoOperations;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.mongodb.client.model.Filters.eq;

class MyService {

    private final MongoOperations mongoTemplate;
    private final MongoClient mongoClient;

    MyService(MongoOperations mongoTemplate, MongoClient mongoClient) {
        this.mongoTemplate = mongoTemplate;
        this.mongoClient = mongoClient;
    }

    void createIfNotExists(String id, List<String> textList) {
        try (ClientSession session = mongoClient.startSession(ClientSessionOptions.builder()
                .causallyConsistent(true)
                .build())) {
            mongoTemplate.withSession(session)
                    .execute(action -> {
                        session.startTransaction();

                        try {
                            MongoCollection<MyDocument> collection = action.getCollection("MyDocument", MyDocument.class)
                                    .withReadConcern(ReadConcern.MAJORITY);
                            if (collection.find(eq("id", id))
                                    .first() == null) {

                                List<MyNestedObject> objectList = textList.stream()
                                        .map(MyNestedObject::new)
                                        .collect(Collectors.toList());

                                collection.insertOne(new MyDocument(id, BigDecimal.ZERO, objectList));
                            }

                            session.commitTransaction();
                        } catch (RuntimeException ex) {
                            session.abortTransaction();
                        }
                        return null;
                    });
        }
    }

    void increment(String id) {
        try (ClientSession session = mongoClient.startSession(ClientSessionOptions.builder()
                .build())) {
            mongoTemplate.withSession(session)
                    .execute(action -> {
                        session.startTransaction();

                        try {
                            MongoCollection<MyDocument> collection = action.getCollection("MyDocument", MyDocument.class);
                            Optional.ofNullable(collection.find(eq("id", id))
                                            .first())
                                    .map(MyDocument::increment)
                                    .ifPresent(collection::insertOne);
                            session.commitTransaction();
                        } catch (RuntimeException ex) {
                            session.abortTransaction();
                        }
                        return null;
                    });
        }
    }

}
