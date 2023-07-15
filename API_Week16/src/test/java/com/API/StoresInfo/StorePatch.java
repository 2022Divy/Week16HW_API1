package com.API.StoresInfo;

import com.API.model.StoresPojo;
import com.API.testbase.TestBase2;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StorePatch extends TestBase2 {
    @Test
    public void patchStore(){
        StoresPojo storesPojo  = new StoresPojo();
        storesPojo.setHours("20");

        given()
                .log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", "1234")
                .body(storesPojo)
                .when()
                .patch("/{id}")
                .then()
                .statusCode(404);
    }
}
