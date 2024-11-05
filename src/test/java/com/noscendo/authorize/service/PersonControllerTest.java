package com.noscendo.authorize.service;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;

import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
class PersonControllerTest {

    @BeforeAll
    static void beforeAll(@LocalServerPort int port) {
        RestAssured.port = port;
    }

    @Test
    void read() {
        given()
                .pathParam("id", 1)
                .when()
                .get("/person/{id}")
                .then()
                .statusCode(403);
    }
}
