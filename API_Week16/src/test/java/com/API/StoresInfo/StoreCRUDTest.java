package com.API.StoresInfo;

import com.API.model.ProductsPojo;
import com.API.model.StoresPojo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoreCRUDTest {
    static int idNumber;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/stores";

    }

    @Test
    public void getAllstoresInfo() {
        given()

                .when()
                .log().all()
                .get()
                .then()
                .statusCode(200);

    }

    @Test
    public void PostStore() {
        StoresPojo datum = new StoresPojo();

        datum.setName("VDP");
        datum.setType("Bits");
        datum.setAddress("126 Frwds drive");
        datum.setAddress2("");
        datum.setCity("Kenton");
        datum.setState("UK");
        datum.setZip("HA3 5Qy");
        datum.setLat(48.1235);
        datum.setLng(-67.466);
        datum.setHours("7");


        Response response = given()
                .log().all()
                .header("Content-Type", "application/json")
                .when()
                .body(datum)
                .post();
        response.then().statusCode(400);
    }

    @Test //update id
    public void testPatch() {
        StoresPojo datum = new StoresPojo();

        datum.setZip("HA1 2FD");

        Response response = given()
                .log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", "1234")
                .when()
                .body(datum)
                .patch("/{id}");
        response.then().statusCode(404);
    }

    @Test// delete it
    public void dele4() {
        given()
                .log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", "1234")
                .when()
                .delete("{id}")
                .then()
                .statusCode(404);
    }

    @Test// retrive id and validate
    public void test005() {
        Response response = given()
                .log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", idNumber)
                .when()
                .get("/{id}");
        response.then().statusCode(404);


    }
    @Test // get only 1 by query parameter
    public void test006() {

        given()
                .queryParam("$limit","1")
                .when()
                .get()
                .then().log().all().statusCode(200);
    }
}
