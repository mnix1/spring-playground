package com.displate.javaenabling.springworkshop.restapi.app3post;

import org.springframework.web.bind.annotation.RestController;

@RestController
class App3RestController {

    private FormDTO lastForm = null;


    void postForm(FormDTO formDTO) {
        this.lastForm = formDTO;
    }

    FormDTO getLastForm() {
        return lastForm;
    }
}

