package com.displate.javaenabling.springworkshop.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class MongoApplication {

	@Bean
	MyRepository myRepository(MongoTemplate mongoTemplate) {
		return new MyRepositoryImpl(mongoTemplate);
	}

	public static void main(String[] args) {
		SpringApplication.run(MongoApplication.class, args);
	}

}
