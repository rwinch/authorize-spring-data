package com.noscendo.authorize.repo;

import com.noscendo.authorize.model.dao.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.security.authorization.method.AuthorizeReturnObject;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long>, JpaSpecificationExecutor<Person> {

    @AuthorizeReturnObject
    Optional<Person> findById(Long id);

    @AuthorizeReturnObject
    Page<Person> findAll(Specification<Person> spec, Pageable pageable);
}
