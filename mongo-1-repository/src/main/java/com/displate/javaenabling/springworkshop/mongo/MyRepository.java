package com.displate.javaenabling.springworkshop.mongo;

import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

interface MyRepository extends CrudRepository<MyDocument, String> {

    Optional<MyDocument> findBySomeValue(BigDecimal someValue);

    List<MyDocument> findBySomeObjectsText(String text);
}
