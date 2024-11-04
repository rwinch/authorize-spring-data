package com.noscendo.authorize.repo;

import com.noscendo.authorize.dao.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
