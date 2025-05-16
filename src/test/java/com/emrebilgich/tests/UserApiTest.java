package com.emrebilgich.tests;

import io.restassured.RestAssured;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertTrue;

public class UserApiTest {

    @Test
    public void getUserById_shouldReturnCorrectUser() {
        long startTime = System.currentTimeMillis();

        RestAssured
            .given()
                .log().all()
            .when()
                .get("https://jsonplaceholder.typicode.com/users/1")
            .then()
                .log().all()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("username", equalTo("Bret"));

        long responseTime = System.currentTimeMillis() - startTime;
        System.out.println("Yanit suresi (ms): " + responseTime);
        assertTrue("Cevap 1 saniyenin altinda degil!", responseTime < 1000);
    }
}