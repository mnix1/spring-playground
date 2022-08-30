package com.displate.javaenabling.springworkshop.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

interface TaskRepository extends MongoRepository<MyEnqueuedTask, String>, TaskRepositoryCustom {
}
