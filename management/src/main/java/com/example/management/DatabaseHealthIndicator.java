package com.example.management;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
class DatabaseHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        return Health.up().withDetail("db", false).build();
    }
}