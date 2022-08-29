package com.example.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/json")
class JSONController {
    private static final Logger LOG = LoggerFactory.getLogger(JSONController.class);
    int i = 0;

    //json returned
    @GetMapping
    Map<String, Object> hello() {
        Map<String, Object> map = new HashMap<>();
        map.put("message", "hello");
        LOG.info("hello " + i);
        map.put("count", i++);
        return map;
    }
}
