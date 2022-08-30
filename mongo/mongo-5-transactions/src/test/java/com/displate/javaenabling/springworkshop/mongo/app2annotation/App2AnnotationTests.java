package com.displate.javaenabling.springworkshop.mongo.app2annotation;

import com.displate.javaenabling.springworkshop.mongo.MongoTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class App2AnnotationTests extends MongoTest {
    @Autowired
    MyService myService;

    @Test
    void test() {
        myService.createIfNotExists("id1", List.of("a", "b"));

        myService.increment("id1");
    }

}
