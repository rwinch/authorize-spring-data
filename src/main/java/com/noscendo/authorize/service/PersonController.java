package com.noscendo.authorize.service;

import com.noscendo.authorize.dao.Person;
import com.noscendo.authorize.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping(value = "/{name}")
    public List<Person> findAllByName(String name) {
        Page<Person> personPage = personRepository.findAllByName(name, PageRequest.ofSize(10));
        return personPage.getContent();
    }
}
