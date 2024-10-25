package com.noscendo.authorize.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonControllerTest {

    @Autowired
    private PersonController personController;

    @Test
    void findAllByName() {
        personController.findAllByName("John");
    }
}