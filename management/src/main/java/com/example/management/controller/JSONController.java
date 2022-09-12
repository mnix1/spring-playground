package com.example.management.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
