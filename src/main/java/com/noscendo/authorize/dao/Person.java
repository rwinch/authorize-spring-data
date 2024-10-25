package com.noscendo.authorize.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.security.access.prepost.PreAuthorize;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @PreAuthorize("permitAll")
    public String getEmail() {
        return email;
    }
}
