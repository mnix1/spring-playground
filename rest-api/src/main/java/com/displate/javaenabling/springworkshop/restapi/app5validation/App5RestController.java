package com.displate.javaenabling.springworkshop.restapi.app5validation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
class App5RestController {

    @PostMapping(value = "/validated-form")
    void postForm(@Valid @RequestBody ValidatedFormDTO formDTO) {
        log.info("All good");
    }
}
