package com.displate.javaenabling.springworkshop.restapi.app2params;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class App2Test {

    @LocalServerPort
    private long port;

    @Autowired
    TestRestTemplate restClient;

    @Test
    void worksWithPathParam() {
        ResponseEntity<String> response = restClient.getForEntity(urlWithPathParam("some-user"), String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("some-user", response.getBody());
    }

    @Test
    void worksWithRequestParam() {
        ResponseEntity<String> response = restClient.getForEntity(urlWithRequestParam("some-user"), String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("some-user", response.getBody());
    }

    @Test
    void worksWithHeader() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("X-USER", "some-user");

        ResponseEntity<String> response = restClient.exchange(urlWithHeader(),
                HttpMethod.GET,
                new HttpEntity<>(httpHeaders),
                String.class
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("some-user", response.getBody());
    }

    private String urlWithPathParam(String user) {
        return String.format("%s/path-param/%s", baseUrl(), user);
    }

    private String urlWithRequestParam(String user) {
        return String.format("%s/request-param?user=%s", baseUrl(), user);
    }

    private String urlWithHeader() {
        return String.format("%s/header", baseUrl());
    }

    private String baseUrl() {
        return String.format("http://localhost:%s/app2", port);
    }

}
