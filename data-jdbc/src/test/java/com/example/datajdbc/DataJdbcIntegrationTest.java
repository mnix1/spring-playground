package com.example.datajdbc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DataJdbcIntegrationTest {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    PersonRepository personRepository;

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
        personRepository.save(new Person(1L, "Doda"));
        personRepository.save(new Person(2L, "Marek Grechuta"));
        //then
        Iterable<Person> persons = personRepository.findAll();
        assertThat(persons).hasSize(2);
        Iterator<Person> iterator = persons.iterator();
        assertThat(iterator.next().name()).isEqualTo("Doda");
        assertThat(iterator.next().name()).isEqualTo("Marek Grechuta");
    }

    private void createTable() {
        jdbcTemplate.execute("""
                CREATE TABLE person(
                id BIGINT PRIMARY KEY,
                version BIGINT,
                name varchar
                )
                """);
    }

    private void maybeDropTable() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS person");
    }
}
