package com.displate.javaenabling.springworkshop.restapi.app5validation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class App5Test {

    @LocalServerPort
    private long port;

    @Autowired
    TestRestTemplate restClient;

    @Test
    void shouldPassForValidName() {
        ResponseEntity<Void> postResponse = restClient.postForEntity(postFormURL(),
                new ValidatedFormDTO("Drake", "Canada"),
                Void.class);

        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
    }


    @Test
    void shouldFailForEmptyName() {
        ResponseEntity<Void> postResponse = restClient.postForEntity(postFormURL(),
                new ValidatedFormDTO("", "Canada"),
                Void.class);

        assertEquals(HttpStatus.BAD_REQUEST, postResponse.getStatusCode());
    }

    private String postFormURL() {
        return String.format("http://localhost:%s/validated-form", port);
    }

}
