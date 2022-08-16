package com.displate.javaenabling.springworkshop.restapi.app3post;

import org.apache.commons.lang3.NotImplementedException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class App3TestRestTemplateTest {

    public static final FormDTO FORM_DTO = new FormDTO("some-user", "Narnia");
    @LocalServerPort
    private long port;

    @Autowired
    TestRestTemplate restClient;

    @Test
    void worksWithDTO() {
        throw new NotImplementedException();
    }

    @Test
    void worksWithPureJSONInRequest() {
        throw new NotImplementedException();
    }

    private String postFormURL() {
        return String.format("%s/form", baseUrl());
    }

    private String getLastFormURL() {
        return String.format("%s/last-form", baseUrl());
    }

    private String baseUrl() {
        return String.format("http://localhost:%s", port);
    }

}
