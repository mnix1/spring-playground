package com.displate.javaenabling.springworkshop.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

interface MyRepository {

    MyDocument save(MyDocument entity);

    Optional<MyDocument> findById(String s);

    Optional<MyDocument> findBySomeValue(BigDecimal someValue);

    List<MyDocument> findBySomeObjectsText(String text);
}
