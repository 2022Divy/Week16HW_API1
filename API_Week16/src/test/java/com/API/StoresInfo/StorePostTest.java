package com.API.StoresInfo;

import com.API.model.StoresPojo;
import com.API.testbase.TestBase2;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StorePostTest extends TestBase2 {

    @Test
    public void Test1(){
        StoresPojo store = new StoresPojo();
        store.setId(1234);
        store.setName("Divya");
        store.setType("Buxtor");
        store.setAddress("123 Frwd drive");
        store.setAddress2("");
        store.setCity("Harrow");
        store.setState("London");
        store.setZip("HA3 5QX");
        store.setLat(48.1234);
        store.setLng(-67.464);
        store.setHours("Tue: 10-9");
        store.setCreatedAt("2015-11-17T17:57:05.708Z");
        store.setUpdatedAt("2023-1-17T17:57:05.708Z");


        given()
                .log().all()
                .header("Content-Type", "application/json; charset=utf-8")
                .body(store)
                .when()
                .post()
                .then()
                .statusCode(400);

    }

}
