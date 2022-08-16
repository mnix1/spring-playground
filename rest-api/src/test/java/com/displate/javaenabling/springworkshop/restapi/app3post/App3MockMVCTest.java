package com.displate.javaenabling.springworkshop.restapi.app3post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class App3MockMVCTest {

    @LocalServerPort
    private long port;

    @Autowired
    MockMvc mockMvc;

    @Test
    void canAssertJsonPath() throws Exception {
        mockMvc.perform(post(postFormURL())
                        .content("""
                                {
                                    "userName": "some-user",
                                    "country": "Narnia"
                                }
                                """)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().is(201));

        mockMvc.perform(get(getLastFormURL()))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.userName", is("some-user")))
                .andExpect(jsonPath("$.country", is("Narnia")));
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
