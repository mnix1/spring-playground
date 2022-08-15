package com.example.exercise1;

import com.example.bootstarter.Role;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("role")
class RoleController {
    @GetMapping
    Role role(HttpServletRequest request) {
        return (Role) request.getAttribute("role");
    }
}
