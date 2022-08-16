package com.example.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class BootApplication {
    private static final Logger LOG = LoggerFactory.getLogger(BootApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

    @PostConstruct
    void init() {
        LOG.info("IT'S RUNNING!!!");
    }
    //TODO sprawdzić czy ExampleService jest dostępny
}
