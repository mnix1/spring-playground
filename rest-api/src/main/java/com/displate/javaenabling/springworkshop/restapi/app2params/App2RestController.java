package com.displate.javaenabling.springworkshop.restapi.app2params;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app2")
class App2RestController {

    @GetMapping("/path-param/{user}")
    String getByPathParam(@PathVariable String user) {
        return user;
    }

    @GetMapping("/request-param")
    String getByRequestParam(@RequestParam String user) {
        return user;
    }

    @GetMapping("/header")
    String getByHeader(@RequestHeader(value = "X-USER") String user) {
        return user;
    }
}
