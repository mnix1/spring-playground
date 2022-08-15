package com.example.bootstarter;

public enum Role {
    ADMIN("a".repeat(10)),
    USER("u".repeat(10)),
    DEVOPS("d".repeat(10)),
    TESTER("t".repeat(10));
    final String token;

    Role(String token) {
        this.token = token;
    }
}
