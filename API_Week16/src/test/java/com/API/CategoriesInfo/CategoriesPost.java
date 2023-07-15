package com.API.CategoriesInfo;

import com.API.model.CategoriesPojo;
import com.API.testbase.TestBase1;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoriesPost extends TestBase1 {
    @Test
    public void Addtest(){
        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setId("pcmcabt748300579355");
        categoriesPojo.setName("Promotion Tools");


        Response response =given()
                .log().all()
                .header("Content-Type","application/json")
                .when()
                .body(categoriesPojo)
                .post();
        response.then().statusCode(201);
    }
}
