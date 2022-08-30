package com.displate.javaenabling.springworkshop.mongo.app2annotation;

import com.displate.javaenabling.springworkshop.mongo.common.MyDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

interface MyAutoRepository extends MongoRepository<MyDocument, String> {
}
