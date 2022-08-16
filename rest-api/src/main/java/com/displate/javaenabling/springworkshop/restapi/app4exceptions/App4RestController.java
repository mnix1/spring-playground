package com.displate.javaenabling.springworkshop.restapi.app4exceptions;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class App4RestController {

    @GetMapping("/bad-request")
    String getBadRequest() {
        throw new RuntimeException("Something wrong");
    }
}