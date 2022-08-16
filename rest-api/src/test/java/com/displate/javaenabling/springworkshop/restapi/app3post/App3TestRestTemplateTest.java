package com.displate.javaenabling.springworkshop.restapi.app3post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class App3TestRestTemplateTest {

    public static final FormDTO FORM_DTO = new FormDTO("some-user", "Narnia");
    @LocalServerPort
    private long port;

    @Autowired
    TestRestTemplate restClient;

    @Test
    void worksWithDTO() {
        ResponseEntity<Void> postResponse = restClient.postForEntity(postFormURL(),
                FORM_DTO,
                Void.class);

        assertEquals(HttpStatus.CREATED, postResponse.getStatusCode());


        ResponseEntity<FormDTO> getResponse = restClient.getForEntity(getLastFormURL(), FormDTO.class);
        assertEquals(HttpStatus.OK, getResponse.getStatusCode());
        assertEquals(FORM_DTO, getResponse.getBody());
    }

    @Test
    void worksWithPureJSON() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<Void> postResponse = restClient.postForEntity(postFormURL(),
                new HttpEntity<>("""
                        {
                            "userName": "some-user",
                            "country": "Narnia"
                        }
                        """,
                        httpHeaders),
                Void.class);

        assertEquals(HttpStatus.CREATED, postResponse.getStatusCode());


        ResponseEntity<FormDTO> getResponse = restClient.getForEntity(getLastFormURL(), FormDTO.class);
        assertEquals(HttpStatus.OK, getResponse.getStatusCode());
        assertEquals(FORM_DTO, getResponse.getBody());
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
