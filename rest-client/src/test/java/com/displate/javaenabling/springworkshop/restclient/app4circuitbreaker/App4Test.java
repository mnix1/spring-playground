package com.displate.javaenabling.springworkshop.restclient.app4circuitbreaker;

import com.displate.javaenabling.springworkshop.restclient.base.WiremockHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class App4Test {


    @Autowired
    MyService myService;


    @RegisterExtension
    static WiremockHelper wiremock = WiremockHelper.buildWiremock();

    @Test
    void shouldReturnEmptyListWhenServiceUnavailable() throws Throwable {
        wiremock.stubFor(get("/users").willReturn(serviceUnavailable()));

        assertEquals(Collections.emptyList(), myService.getUsers());

        wiremock.verify(10, getRequestedFor(urlMatching("/users")));
    }

}
