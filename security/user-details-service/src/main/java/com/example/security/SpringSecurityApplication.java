package com.example.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true
)
public class SpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

    @Bean
    CustomUserRepository userRepository() {
        // the hashed password was calculated using the following code
        // the hash should be done up front, so malicious users cannot discover the password
        // PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        // String encodedPassword = encoder.encode("password");

        // the raw password is "password"
        String encodedPassword = "{bcrypt}$2a$10$h/AJueu7Xt9yh3qYuAXtk.WZJ544Uc2kdOKlHu2qQzCh/A3rq46qm";

        CustomUser user = new CustomUser(1L, "user@example.com", false, encodedPassword);
        CustomUser admin = new CustomUser(2L, "admin@example.com", true, encodedPassword);
        Map<String, CustomUser> emailToCustomUser = new HashMap<>();
        emailToCustomUser.put(user.getEmail(), user);
        emailToCustomUser.put(admin.getEmail(), admin);
        return emailToCustomUser::get;
    }
}
