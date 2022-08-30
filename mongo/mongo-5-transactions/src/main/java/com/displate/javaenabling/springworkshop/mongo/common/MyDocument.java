package com.displate.javaenabling.springworkshop.mongo.common;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Document
public record MyDocument(@Id String id,
                         BigDecimal someValue,
                         List<MyNestedObject> someObjects) {

    public MyDocument increment() {
        return new MyDocument(id, someValue.add(BigDecimal.ONE), someObjects);
    }

}
