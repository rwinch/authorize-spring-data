package com.noscendo.authorize.service;

import com.noscendo.authorize.dao.Person;
import com.noscendo.authorize.repo.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authorization.method.AuthorizeReturnObject;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    @AuthorizeReturnObject
    public Person retrieve(Long id) {
        return personRepository.findById(id).orElseThrow();
    }
}
