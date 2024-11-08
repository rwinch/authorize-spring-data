package com.noscendo.authorize;

import com.noscendo.authorize.dao.Person;
import com.noscendo.authorize.repo.PersonRepository;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class AuthorizeSpringDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthorizeSpringDataApplication.class, args);
    }

    @Bean
    ApplicationRunner init(PersonRepository people) {
        return args -> {
            Person p = new Person();
            p.setEmail("rob@example.com");
            p.setName("Rob");
            p.setId(1L);
            people.save(p);
            people.flush();
        };
    }
}
