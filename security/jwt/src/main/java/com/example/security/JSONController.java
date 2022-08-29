package com.example.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
class JSONController {
    private static final Logger LOG = LoggerFactory.getLogger(JSONController.class);
    int i = 0;

    @GetMapping("/json")
    Map<String, Object> hello() {
        Map<String, Object> map = new HashMap<>();
        map.put("message", "hello");
        LOG.info("hello " + i);
        map.put("count", i++);
        return map;
    }

    @GetMapping("/user")
    public Authentication user(Authentication authentication) {
        return authentication;
    }

    @GetMapping("/hello")
    public String hello(Authentication authentication) {
        return "Hello, " + authentication.getName() + "!";
    }
}
