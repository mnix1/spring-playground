package com.displate.javaenabling.springworkshop.restapi.app3post;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
class App3RestController {

    private FormDTO lastForm = null;

    @PostMapping(value = "/form")
    @ResponseStatus(HttpStatus.CREATED)
    void postForm(@RequestBody FormDTO formDTO) {
        this.lastForm = formDTO;
    }

    @GetMapping(value = "/last-form")
    FormDTO getLastForm() {
        return lastForm;
    }
}

