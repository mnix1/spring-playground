package com.displate.javaenabling.springworkshop.mongo.app3template;

import com.displate.javaenabling.springworkshop.mongo.common.MyDocument;
import com.displate.javaenabling.springworkshop.mongo.common.MyNestedObject;
import com.displate.javaenabling.springworkshop.mongo.common.MyRepository;
import org.springframework.transaction.support.TransactionTemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

class MyService {

    private final TransactionTemplate transactionTemplate;
    private final MyRepository repository;

    MyService(TransactionTemplate transactionTemplate, MyRepository repository) {
        this.transactionTemplate = transactionTemplate;
        this.repository = repository;
    }

    void createIfNotExists(String id, List<String> textList) {
        transactionTemplate.execute((status) -> {
            if (!repository.existsById(id)) {
                List<MyNestedObject> objectList = textList.stream()
                        .map(MyNestedObject::new)
                        .collect(Collectors.toList());
                MyDocument document = new MyDocument(id, BigDecimal.ZERO, objectList);
                repository.save(document);
                return document;
            }
            return null;
        });
    }

    void increment(String id) {
        transactionTemplate.execute((status) -> repository.findById(id)
                .map(MyDocument::increment)
                .map(repository::save)
                .orElse(null));
    }
}
