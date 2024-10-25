package com.noscendo.authorize.repo;

import com.noscendo.authorize.dao.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.authorization.method.AuthorizeReturnObject;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @AuthorizeReturnObject
    Page<Person> findAllByName(String name, Pageable pageable);
}
