package com.API.ProductsInffo;

import com.API.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductDeleteTest extends TestBase {
    @Test
    public void delete() {
        given()
                .log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", "9999679")
                .when()
                .delete("{id}")
                .then()
                .statusCode(404);
    }
}