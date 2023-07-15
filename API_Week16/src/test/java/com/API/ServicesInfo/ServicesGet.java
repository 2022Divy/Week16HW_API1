package com.API.ServicesInfo;

import com.API.testbase.TestBase3;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ServicesGet extends TestBase3 {
    static ValidatableResponse response;

    @Test
    public void getAllServicesInfo() {
        response = given()
                .when()
                .get().then().log().all();

        response.statusCode(200);
}
    @Test
    public void getSingleServiceInfo() {
        response = given()
                .pathParam("id", 4)
                .when()
                .get("/{id}")
                .then();
        response.statusCode(200);
    }
}
