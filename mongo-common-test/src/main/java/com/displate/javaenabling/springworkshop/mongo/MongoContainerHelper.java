package com.displate.javaenabling.springworkshop.mongo;

import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.utility.DockerImageName;

class MongoContainerHelper {
    MongoDBContainer mongoDBContainer;

    void startMongoContainer() {
        mongoDBContainer = new MongoDBContainer(DockerImageName.parse("mongo:4.4.16"));
        mongoDBContainer.start();
        System.setProperty("spring.data.mongodb.uri", mongoDBContainer.getReplicaSetUrl());
    }
}
