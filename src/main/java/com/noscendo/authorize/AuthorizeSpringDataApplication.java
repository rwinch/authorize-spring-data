package com.noscendo.authorize;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@EnableJpaRepositories
@EnableMethodSecurity
@SpringBootApplication
public class AuthorizeSpringDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthorizeSpringDataApplication.class, args);
    }
}
