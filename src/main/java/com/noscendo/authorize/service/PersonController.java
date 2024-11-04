package com.noscendo.authorize.service;

import com.noscendo.authorize.dao.Person;
import com.noscendo.authorize.repo.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authorization.method.AuthorizeReturnObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AuthorizeReturnObject
@RequiredArgsConstructor
@RestController
public class PersonController {

    private final PersonRepository personRepository;

    @GetMapping(value = "/authorized/{id}")
    public Person authorized(@PathVariable Long id) {
        return personRepository.findById(id).orElseThrow();
    }

    @GetMapping(value = "/notAuthorized/{id}")
    public ResponseEntity<Person> notAuthorized(@PathVariable Long id) {
        return ResponseEntity.ok(personRepository.findById(id).orElseThrow());
    }
}
