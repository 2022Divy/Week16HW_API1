package com.API.ProductsInffo;

import com.API.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductGetTest extends TestBase {
    static ValidatableResponse response;

    @Test
    public void getAllProductsInfo() {
        response = given()
                .when()
                .get().then();

        response.statusCode(200);
    }

    @Test
    public void getSingleProductInfo() {
        response = given()
                .pathParam("id", 43900)
                .when()
                .get("/{id}")
                .then();
        response.statusCode(200);
    }

}