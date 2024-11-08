package com.noscendo.authorize.service;

import com.noscendo.authorize.model.dao.Person;
import com.noscendo.authorize.repo.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.aop.framework.Advised;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

// TODO @AuthorizeReturnObject
@RequiredArgsConstructor
@Service
public class PersonService {

    // TODO   private final PersonMapper personMapper;
    private final PersonRepository personRepository;

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public Person findAuthorized(Long id) {
        Person proxy = personRepository.findById(id).orElseThrow();
        proxy.getId(); // this triggers @PreAuthorize check
        return unwrap(proxy);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public Page<Person> findAllAuthorized(Specification<Person> spec, Pageable pageable) {
        Page<Person> page = personRepository.findAll(spec, pageable);
        page.get().map(Person::getId); // this triggers @PreAuthorize check
        return unwrap(page);
    }

    @SuppressWarnings("unchecked")
    private <T> T unwrap(T proxy) {
        try {
            return proxy instanceof Advised advised ? (T) advised.getTargetSource().getTarget() : proxy;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*
    // TODO check happens to late!
    private Person create(PersonRequest request) {
        Person created = personMapper.create(request);
        return personRepository.save(created);
    }

    // TODO check happens to late!
    private Person read(Long id) {
        return personRepository.findById(id).orElseThrow();
    }

    // TODO check happens to late!
    private Person patch(Long id, PersonRequest request) {
        Person existing = personRepository.findById(id).orElseThrow();
        Person patched = personMapper.patch(request, existing);
        return personRepository.save(patched);
    }

    // TODO check happens to late!
    private Person update(Long id, PersonRequest request) {
        Person existing = personRepository.findById(id).orElseThrow();
        Person patched = personMapper.update(request, existing);
        return personRepository.save(patched);
    }

    // TODO check never happens!
    private void delete(Long id) {
        personRepository.deleteById(id);
    }
    */
}
