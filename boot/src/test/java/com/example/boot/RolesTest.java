package com.example.boot;

import com.example.bootstarter.RoleClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RolesTest {

    @Autowired
    RoleClient roleClient;

    @Test
    void returnsRoles(){
        assertThat(roleClient.fetch()).contains("ADMIN", "USER", "DEVOPS", "TESTER");
    }
}
