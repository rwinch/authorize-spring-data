package com.noscendo.authorize.api;

import com.noscendo.authorize.dao.Person;
import com.noscendo.authorize.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/person")
@RequiredArgsConstructor
@RestController
@Slf4j
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody Person person) {
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Person> read(@PathVariable Long id) {
        Person retrieve = personService.retrieve(id);
        log.warn(retrieve.getName());
        return ResponseEntity.ok(retrieve);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Person> patch(@RequestBody Person person) {
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@RequestBody Person person) {
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }
}
