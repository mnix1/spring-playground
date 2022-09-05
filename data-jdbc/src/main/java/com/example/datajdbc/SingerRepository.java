package com.example.datajdbc;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class SingerRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public SingerRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Singer> findAll() {
        return jdbcTemplate.query("SELECT * FROM singer", Map.of(), (rs, rowNum) -> new Singer(rs.getLong("id"), rs.getString("name")));
    }

    public void save(Singer singer) {
        String sql = """
                INSERT INTO singer (id, name) VALUES (:id, :name)
                """;
        jdbcTemplate.update(sql, Map.of("id", singer.id(), "name", singer.name()));
    }
}
