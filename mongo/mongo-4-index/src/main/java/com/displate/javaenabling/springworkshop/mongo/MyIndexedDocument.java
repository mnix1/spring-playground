package com.displate.javaenabling.springworkshop.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document
@CompoundIndexes(
        @CompoundIndex(name = "value", def = "{'someValue': 1, 'otherValue': 1}", background = true)
)
record MyIndexedDocument(@Id String id,
                         @Indexed(background = true)
                  BigDecimal someValue,
                         BigDecimal otherValue) {
}
