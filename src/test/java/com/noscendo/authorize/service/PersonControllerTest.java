package com.noscendo.authorize.service;

import com.noscendo.authorize.model.api.PersonRequest;
import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import org.instancio.Instancio;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;

import static io.restassured.RestAssured.given;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
class PersonControllerTest {

    @BeforeAll
    static void beforeAll(@LocalServerPort int port) {
        RestAssured.port = port;
    }

    @Test
    void post() {
        PersonRequest request = Instancio.create(PersonRequest.class);

        given()
                .body(request)
                .contentType("application/json")
                .when()
                .post("/person")
                .then()
                .statusCode(200);
    }

    @Test
    void get() {
        given()
                .pathParam("id", 1)
                .when()
                .get("/person/{id}")
                .then()
                .statusCode(403);
    }

    @Test
    void patch() {
        PersonRequest request = Instancio.create(PersonRequest.class);

        given()
                .pathParam("id", 1)
                .body(request)
                .contentType("application/json")
                .when()
                .patch("/person/{id}")
                .then()
                .statusCode(403);
    }

    @Test
    void put() {
        PersonRequest request = Instancio.create(PersonRequest.class);

        given()
                .pathParam("id", 1)
                .body(request)
                .contentType("application/json")
                .put("/person/{id}")
                .then()
                .statusCode(403);
    }

    @Test
    void delete() {
        given()
                .pathParam("id", 999)
                .when()
                .delete("/person/{id}")
                .then()
                .statusCode(403);
    }
}
