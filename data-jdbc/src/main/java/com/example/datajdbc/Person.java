package com.example.datajdbc;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

public final class Person {
    @Id
    private Long id;
    @Version
    private Long version;
    private String name;

    public Person(Long id, Long version, String name) {
        this.id = id;
        this.version = version;
        this.name = name;
    }

    public Person(Long id, String name) {
        this(id, null, name);
    }

    public Person() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Id
    public Long id() {
        return id;
    }

    @Version
    public Long version() {
        return version;
    }

    public String name() {
        return name;
    }
}
