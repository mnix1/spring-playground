package com.displate.javaenabling.springworkshop.mongo;

import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.Optional;

interface MyRepository extends CrudRepository<MyIndexedDocument, String> {

    Optional<MyIndexedDocument> findBySomeValue(BigDecimal someValue);

}
