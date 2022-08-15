package com.example.exercise1;

import com.example.bootstarter.Role;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;


import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RoleTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    @ParameterizedTest
    @MethodSource("arguments")
    void returnsRole(String token, Role role) {
        //when
        ResponseEntity<Role> exchange = exchange(token);
        //then
        assertThat(exchange.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(exchange.getBody()).isEqualTo(role);
    }

    static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of("a".repeat(10), Role.ADMIN),
                Arguments.of("u".repeat(10), Role.USER),
                Arguments.of("d".repeat(10), Role.DEVOPS),
                Arguments.of("t".repeat(10), Role.TESTER)
        );
    }

    @Test
    void returnsUnauthorizedWhenRoleNotExist() {
        //when
        ResponseEntity<Role> exchange = exchange("a".repeat(11));
        //then
        assertThat(exchange.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
        assertThat(exchange.getBody()).isNull();
    }

    @Test
    void returnsUnauthorizedWhenNoToken() {
        //when
        ResponseEntity<Role> exchange = exchange(null);
        //then
        assertThat(exchange.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
        assertThat(exchange.getBody()).isNull();
    }

    @Test
    void returnsForbiddenWhenRoleNotExist() {
        //when
        ResponseEntity<Role> exchange = exchange("b".repeat(10));
        //then
        assertThat(exchange.getStatusCode()).isEqualTo(HttpStatus.FORBIDDEN);
        assertThat(exchange.getBody()).isNull();
    }

    private ResponseEntity<Role> exchange(String token) {
        HttpHeaders headers = new HttpHeaders();
        if (token != null) {
            headers.add(HttpHeaders.AUTHORIZATION, token);
        }
        return testRestTemplate.exchange("/role", HttpMethod.GET, new HttpEntity<>(null, headers), Role.class);
    }
}
