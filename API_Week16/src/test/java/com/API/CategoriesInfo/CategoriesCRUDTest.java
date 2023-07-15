package com.API.CategoriesInfo;

import com.API.model.CategoriesPojo;
import com.API.model.ProductsPojo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoriesCRUDTest {
    static int idNumber;

    @BeforeClass
    public static void inte() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/categories";
    }

    @Test
    public void getAll() {
        given()
                .when()
                .log().all()
                .get()
                .then().log().all().statusCode(200);
    }

    @Test
    public void addNew() {
        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setId("pcmcabt748300579355");
        categoriesPojo.setName("Promotion Tools");


        Response response = given()
                .log().all()
                .header("Content-Type", "application/json")
                .when()
                .body(categoriesPojo)
                .post();
        response.then().statusCode(201);

    }

    @Test
    public void updateCat() {
        CategoriesPojo catPojo = new CategoriesPojo();
        catPojo.setName("Goodwork");

        Response response = given()
                .log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", "pcmcabt748300579355")
                .when()
                .body(catPojo)
                .patch("/{id}");
        response.then().statusCode(200);
    }

    @Test
    public void deleteCat() {
        Response response = given()
                .log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", "pcmcabt748300579355")
                .when()
                .delete("/{id}");
        response.then().statusCode(200);
    }

    @Test
    public void retrv() {
        Response response = given()
                .log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", "pcmcabt748300579355")
                .when()
                .get("/{id}");
        response.then().statusCode(404);

    }
}