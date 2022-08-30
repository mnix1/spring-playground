package com.displate.javaenabling.springworkshop.mongo.app3template;

import com.displate.javaenabling.springworkshop.mongo.common.MyRepositoryImpl;
import com.mongodb.ReadConcern;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.transaction.support.TransactionTemplate;

@SpringBootApplication
public class App3Template {

    @Bean
    MongoTransactionManager mongoTransactionManager(MongoDatabaseFactory dbFactory) {
        MongoTransactionManager mongoTransactionManager = new MongoTransactionManager(dbFactory);
        mongoTransactionManager.setOptions(TransactionOptions.builder()
                .readConcern(ReadConcern.MAJORITY)
                .writeConcern(WriteConcern.MAJORITY)
                .build());
        return mongoTransactionManager;
    }

    @Bean
    MyService service(TransactionTemplate transactionTemplate, MongoTemplate mongoTemplate) {
        return new MyService(transactionTemplate, new MyRepositoryImpl(mongoTemplate));
    }

    public static void main(String[] args) {
        SpringApplication.run(App3Template.class, args);
    }

}
