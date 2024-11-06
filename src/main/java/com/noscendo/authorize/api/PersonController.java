package com.noscendo.authorize.api;

import com.noscendo.authorize.mapper.PersonMapper;
import com.noscendo.authorize.model.api.PersonRequest;
import com.noscendo.authorize.model.api.PersonResponse;
import com.noscendo.authorize.model.dao.Person;
import com.noscendo.authorize.repo.PersonRepository;
import com.noscendo.authorize.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/person")
@RequiredArgsConstructor
@RestController
@Slf4j
@Transactional
public class PersonController {

    private final PersonMapper personMapper;
    private final PersonService personService;
    private final PersonRepository personRepository;

    @PostMapping
    public ResponseEntity<PersonResponse> post(@RequestBody PersonRequest request) {
//        Person created = personService.create(request);
        Person created = personMapper.create(request);
        Person saved = personRepository.save(created);
        return ResponseEntity.ok(personMapper.retrieve(saved));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonResponse> get(@PathVariable Long id) {
//        Person read = personService.read(id);
        Person read = personService.findAuthorized(id);
        return ResponseEntity.ok(personMapper.retrieve(read));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PersonResponse> patch(@PathVariable Long id, @RequestBody PersonRequest request) {
//        Person read = personService.read(id);
//        Person patched = personService.patch(id, request);
        Person existing = personService.findAuthorized(id);
        Person patched = personMapper.patch(request, existing);
        Person saved = personRepository.save(patched);
        return ResponseEntity.ok(personMapper.retrieve(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonResponse> put(@PathVariable Long id, @RequestBody PersonRequest request) {
//        Person updated = personService.update(id, request);
//        Person existing = personRepository.findById(id).orElseThrow();
        Person existing = personService.findAuthorized(id);
        Person patched = personMapper.update(request, existing);
        Person saved = personRepository.save(patched);
        return ResponseEntity.ok(personMapper.retrieve(saved));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        personService.delete(id);
        Person existing = personService.findAuthorized(id);
        personRepository.delete(existing);
        return ResponseEntity.noContent().build();
    }
}
