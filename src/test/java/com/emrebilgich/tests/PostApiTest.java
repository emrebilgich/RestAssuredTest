package com.emrebilgich.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

public class PostApiTest {

    @Test
    public void createPost_shouldReturnCreatedPost() {
        String jsonBody = """
            {
              "title": "foo",
              "body": "bar",
              "userId": 1
            }
        """;

        RestAssured
            .given()
                .contentType(ContentType.JSON)
                .body(jsonBody)
                .log().all()
            .when()
                .post("https://jsonplaceholder.typicode.com/posts")
            .then()
                .log().all()
                .statusCode(201)
                .body("title", equalTo("foo"))
                .body("body", equalTo("bar"))
                .body("userId", equalTo(1));
    }
}