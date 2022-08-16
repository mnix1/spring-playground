package com.displate.javaenabling.springworkshop.context.app1component;


import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
class UserRepository {
    private final Map<String, User> storage = new ConcurrentHashMap<>();

    void save(User user) {
        storage.put(user.getUserName(), user);
    }

    User findByUserName(String username) {
        return storage.get(username);
    }
}
