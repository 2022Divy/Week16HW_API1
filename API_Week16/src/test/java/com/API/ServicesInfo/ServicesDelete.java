package com.API.ServicesInfo;

import com.API.testbase.TestBase3;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ServicesDelete extends TestBase3 {
    @Test
    public void deleteService(){
        given()
                .log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", "3")
                .when()
                .delete("/{id}")
                .then()
                .statusCode(404);
    }
}
