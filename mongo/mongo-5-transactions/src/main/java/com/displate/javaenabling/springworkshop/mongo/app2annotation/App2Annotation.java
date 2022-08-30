package com.displate.javaenabling.springworkshop.mongo.app2annotation;

import com.displate.javaenabling.springworkshop.mongo.common.MyRepository;
import com.displate.javaenabling.springworkshop.mongo.common.MyRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class App2Annotation {

    @Bean
    MyRepository myRepository(MongoTemplate mongoTemplate) {
        return new MyRepositoryImpl(mongoTemplate);
    }

    public static void main(String[] args) {
        SpringApplication.run(App2Annotation.class, args);
    }

}