package com.example.bootstarter;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

//TODO sprawdzić czy bean będzie dostępny
@Service
public class RoleService {
    public Optional<Role> findRole(String token) {
        return Arrays.stream(Role.values()).filter(role -> role.token.equals(token)).findFirst();
    }
}
