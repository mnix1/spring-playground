package com.example.bootstarter;

import java.util.Arrays;
import java.util.Optional;

public class RoleService {
    public Optional<Role> findRole(String token) {
        return Arrays.stream(Role.values()).filter(role -> role.token.equals(token)).findFirst();
    }
}
