package com.displate.javaenabling.springworkshop.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Document
record MyDocument(@Id String id,
                  BigDecimal someValue,
                  List<MyNestedObject> someObjects) {
}

record MyNestedObject(String text) {
}