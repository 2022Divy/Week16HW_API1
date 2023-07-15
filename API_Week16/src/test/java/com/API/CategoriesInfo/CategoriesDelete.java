package com.API.CategoriesInfo;

import com.API.testbase.TestBase1;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoriesDelete extends TestBase1 {
    @Test
    public void deleteCat() {
        Response response = given()
                .log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", "abcat0010000")
                .when()
                .delete("/{id}");
        response.then().statusCode(200);
    }
}
