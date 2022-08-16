package com.displate.javaenabling.springworkshop.restapi.app6swagger;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/app2")
@Slf4j
class App6RestController {

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

    @PostMapping(value = "/validated-form")
    void postForm(@Valid @RequestBody ValidatedFormDTO formDTO) {
        log.info("All good");
    }
}
