package com.API.StoresInfo;

import com.API.model.StoresPojo;
import com.API.testbase.TestBase2;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StorePut extends TestBase2 {
    @Test
    public void PutStore() {

        StoresPojo stores = new StoresPojo();
        stores.setType("Brixton");
        stores.setAddress("123 Kenton lane");
        stores.setAddress2("");
        stores.setCity("Wembley");
        stores.setState("UK");
        stores.setZip("HA3 5RU");


        given()
                .log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", "1234")
                .body(stores)
                .when()
                .put("/{id}")
                .then()
                .statusCode(400);
    }
}