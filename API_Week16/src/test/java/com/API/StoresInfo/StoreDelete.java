package com.API.StoresInfo;

import com.API.testbase.TestBase2;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoreDelete extends TestBase2 {
    @Test
    public void deleteStore(){
        given()
                .log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", "1234")
                .when()
                .delete("{id}")
                .then()
                .statusCode(404);
    }
}
