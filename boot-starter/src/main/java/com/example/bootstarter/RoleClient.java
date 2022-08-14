package com.example.bootstarter;

import java.util.List;

public class RoleClient {
    public List<String> fetch() {
        return List.of("ADMIN", "USER", "DEVOPS", "TESTER");
    }
}
