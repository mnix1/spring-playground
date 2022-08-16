package com.example.mvcboot.controller;

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

    //etag
    @GetMapping("etag")
    ResponseEntity<Map<String, Object>> helloEtag() {
        Map<String, Object> map = new HashMap<>();
        map.put("message", "hello");
        LOG.info("etag " + i);
        map.put("count", i++);
        return ResponseEntity.ok()
                .eTag("hello")
                .body(map);
    }

    //cache
    @GetMapping("cacheControl")
    ResponseEntity<Map<String, Object>> helloCacheControl() {
        Map<String, Object> map = new HashMap<>();
        map.put("message", "hello");
        LOG.info("cacheControl " + i);
        map.put("count", i++);
        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(30, TimeUnit.SECONDS))
                .body(map);
    }

    //cache control + etag
    @GetMapping("etagAndCacheControl")
    ResponseEntity<Map<String, Object>> helloETagAndCacheControl() {
        Map<String, Object> map = new HashMap<>();
        map.put("message", "hello");
        LOG.info("etagAndCacheControl "+i);
        map.put("count", i++);
        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(5, TimeUnit.SECONDS))
                .eTag("hello")
                .body(map);
    }
    //path variable example
    @GetMapping("{id}")
    public @ResponseBody ResponseEntity<String> getById(@PathVariable String id) {
        return new ResponseEntity<>("GET Response : " + id, HttpStatus.OK);
    }
}
