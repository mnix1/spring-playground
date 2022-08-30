package com.displate.javaenabling.springworkshop.mongo.app1session;

import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class App1Annotation {

    @Bean
    MyService service(MongoTemplate mongoTemplate, MongoClient mongoClient) {
        mongoTemplate.setWriteConcern(WriteConcern.MAJORITY);

        return new MyService(mongoTemplate, mongoClient);
    }

    public static void main(String[] args) {
        SpringApplication.run(App1Annotation.class, args);
    }

}
