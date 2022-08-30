package com.example.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    @PreAuthorize("hasRole('ROLE_USER')")
    public CustomUser user(@AuthenticationPrincipal CustomUser currentUser) {
        return currentUser;
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public CustomUser admin(@AuthenticationPrincipal CustomUser currentUser) {
        return currentUser;
    }
}
