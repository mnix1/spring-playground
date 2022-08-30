package com.displate.javaenabling.springworkshop.mongo;

import org.junit.jupiter.api.BeforeAll;

public class MongoTest {
    private static final MongoContainerHelper mongoContainerHelper = new MongoContainerHelper();

    @BeforeAll
    static void setupSpec() {
        mongoContainerHelper.startMongoContainer();
    }

}
