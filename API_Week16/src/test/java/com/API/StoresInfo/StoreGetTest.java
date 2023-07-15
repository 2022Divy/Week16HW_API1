package com.API.StoresInfo;

import com.API.testbase.TestBase2;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoreGetTest extends TestBase2 {
    static ValidatableResponse response;

    @Test
    public void getAllstoresInfo() {
        response = given()
                .when()
                .get().then();

        response.statusCode(200);
    }

    @Test
    public void getSingleStoresInfo() {
        response = given()
                .pathParam("id", 4)
                .when()
                .get("/{id}")
                .then();
        response.statusCode(200);
    }
}
