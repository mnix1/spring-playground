package com.example.bootstarter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = RolesAutoConfiguration.class)
class ConfigurationTest {

    @Autowired
    RoleClient roleClient;

    @Test
    void returnsRoles() {
        assertThat(roleClient.fetch()).contains("ADMIN", "USER", "DEVOPS", "TESTER");
    }
}
