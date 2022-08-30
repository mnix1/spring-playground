package com.displate.javaenabling.springworkshop.mongo.common;

import java.util.Optional;

public interface MyRepository {
    MyDocument save(MyDocument entity);

    Optional<MyDocument> findById(String id);

    boolean existsById(String id);
}

