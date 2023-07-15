package com.API.CategoriesInfo;

import com.API.testbase.TestBase1;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoriesGet extends TestBase1 {
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
                .pathParam("id", "pcmcat84000050004")
                .when()
                .get("/{id}")
                .then();
        response.statusCode(200);
    }
}
