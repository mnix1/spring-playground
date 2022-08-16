package com.displate.javaenabling.springworkshop.restapi.app1get;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class App1RestController {

    @GetMapping("/stuff")
    String getStuff() {
        return "actual stuff";
    }
}
