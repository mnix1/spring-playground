package com.example.mvcboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
class JSONController {
    int i = 0;

    @GetMapping("/")
    Map<String, Object> hello() {
        Map<String, Object> map = new HashMap<>();
        map.put("message", "hello");
        map.put("count", i++);
        return map;
    }
}
