package com.noscendo.authorize.repo;

import com.noscendo.authorize.model.dao.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.authorization.method.AuthorizeReturnObject;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @AuthorizeReturnObject
    Optional<Person> findById(Long id);
}
