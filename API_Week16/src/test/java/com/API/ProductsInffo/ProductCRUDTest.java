package com.API.ProductsInffo;


import com.API.model.ProductsPojo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductCRUDTest {
    static int idNumber;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost"; // base URI
        RestAssured.port = 3030; // port number
        RestAssured.basePath = "/products"; // endpoints
    }

    @Test // get all list
    public void test001() {

        given()
                .when()
                .log().all()
                .get()
                .then().log().all().statusCode(200);
    }

    @Test // post new and retrive id
    public void test002() {

        ProductsPojo datum = new ProductsPojo();
        datum.setName("Energizer 1222");
        datum.setType("HardGood");
        datum.setPrice(499);
        datum.setUpc("039800011229");
        datum.setShipping(0);
        datum.setDescription("4-pack AA alkaline batteries; battery tester included");
        datum.setManufacturer("nike");
        datum.setModel("tesla");
        datum.setUrl("http://www.bestbuy.com/site/energizer-max-batteries-aa-4-pack/150115.p?id=1051384046217&skuId=150115&cmp=RMXCC");


        Response response =given()
                .log().all()
                .header("Content-Type","application/json")
                .when()
                .body(datum)
                .post();
        response.then().statusCode(201);
        idNumber=response.then().extract().path("id");
        System.out.println(idNumber);


    }

    @Test //update id
    public void test003() {
        ProductsPojo datum = new ProductsPojo();

        Response response =given()
                .log().all()
                .header("Content-Type","application/json")
                .pathParam("id",idNumber)
                .when()
                .body(datum)
                .patch("/{id}");
        response.then().statusCode(200);

    }

    @Test// delete it
    public void test004() {
        Response response =given()
                .log().all()
                .header("Content-Type","application/json")
                .pathParam("id",idNumber)
                .when()
                .delete("/{id}");
        response.then().statusCode(200);
    }

    @Test// retrive id and validate
    public void test005() {
        Response response =given()
                .log().all()
                .header("Content-Type","application/json")
                .pathParam("id",idNumber)
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



