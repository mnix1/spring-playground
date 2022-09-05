package com.example.datajdbc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class JdbcIntegrationTest {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    SingerRepository singerRepository;

    @BeforeEach
    void setUp() {
        maybeDropTable();
        createTable();
    }

    @AfterEach
    void tearDown() {
        maybeDropTable();
    }

    @Test
    void createsAndGets() {
        //when
        singerRepository.save(new Singer(1L, "Doda"));
        singerRepository.save(new Singer(2L, "Marek Grechuta"));
        //then
        List<Singer> singers = singerRepository.findAll();
        assertThat(singers).hasSize(2);
        assertThat(singers.get(1).name()).isEqualTo("Marek Grechuta");
    }

    private void createTable() {
        jdbcTemplate.execute("""
                CREATE TABLE singer(
                id BIGINT PRIMARY KEY,
                name varchar
                )
                """);
    }

    private void maybeDropTable() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS singer");
    }
}
