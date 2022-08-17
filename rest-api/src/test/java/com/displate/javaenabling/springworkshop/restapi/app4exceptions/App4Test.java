package com.displate.javaenabling.springworkshop.restapi.app4exceptions;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class App4Test {

	@LocalServerPort
	private long port;

	@Autowired
	TestRestTemplate restClient;

	@Test
	void shouldReturnBadRequest() {
		ResponseEntity<String> response = restClient.getForEntity(String.format("http://localhost:%s/bad-request", port), String.class);

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

}
