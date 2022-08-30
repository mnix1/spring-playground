package com.displate.javaenabling.springworkshop.mongo.app2annotation;

import com.displate.javaenabling.springworkshop.mongo.common.MyDocument;
import com.displate.javaenabling.springworkshop.mongo.common.MyNestedObject;
import com.displate.javaenabling.springworkshop.mongo.common.MyRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Component
class MyService {

    private final MyRepository repository;


    MyService(MyRepository repository) {
        this.repository = repository;
    }

    //Doesn't work - transaction doesn't start. Don't use this
    @Transactional
    void createIfNotExists(String id, List<String> textList) {
        if (!repository.existsById(id)) {
            List<MyNestedObject> objectList = textList.stream()
                    .map(MyNestedObject::new)
                    .collect(Collectors.toList());
            MyDocument document = new MyDocument(id, BigDecimal.ZERO, objectList);
            repository.save(document);
        }
    }

    //Doesn't work - transaction doesn't start. Don't use this
    @Transactional
    void increment(String id) {
        repository.findById(id)
                .map(MyDocument::increment)
                .ifPresent(repository::save);
    }
}
