package org.acme.rest.json;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;

import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ProductResourceTest {
/*
    @Test
    public void testList() {
        given()
                .when().get("/product")
                .then()
                .statusCode(200)
                .body("$.size()", is(2),
                        "id", containsInAnyOrder(1, 2),
                        "productname", containsInAnyOrder("bag", "chair"));
    }*/

    @Test
    public void testAdd() {
        given()
                .body("{\"id\": \"3\", \"productname\": \"Winter fruit\"}")
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .when()
                .post("/product")
                .then()
                .statusCode(200)
                .body("$.size()", is(3),
                        "id", containsInAnyOrder(1,2,3),
                        "productname", containsInAnyOrder("bag", "chair", "Winter fruit"));

       /* given()
                .body("{\"id\": \"1\", \"productname\": \"bag\"}")
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .when()
                .delete("/product")
                .then()
                .statusCode(200)
                .body("$.size()", is(2),
                        "id", containsInAnyOrder(2,3),
                        "productname", containsInAnyOrder("chair"));*/
    }
}