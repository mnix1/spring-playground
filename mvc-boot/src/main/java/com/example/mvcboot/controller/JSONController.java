package com.example.mvcboot.controller;

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
    int i = 0;

    @GetMapping
    Map<String, Object> hello() {
        Map<String, Object> map = new HashMap<>();
        map.put("message", "hello");
        map.put("count", i++);
        return map;
    }


    @GetMapping("cached")
    ResponseEntity<Map<String, Object>> helloCached() {
        Map<String, Object> map = new HashMap<>();
        map.put("message", "hello");
        map.put("count", i++);
        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(30, TimeUnit.DAYS))
                .eTag("hello")
                .body(map);
    }

    @GetMapping("{id}")
    public @ResponseBody ResponseEntity<String> getById(@PathVariable String id) {
        return new ResponseEntity<>("GET Response : " + id, HttpStatus.OK);
    }
}
