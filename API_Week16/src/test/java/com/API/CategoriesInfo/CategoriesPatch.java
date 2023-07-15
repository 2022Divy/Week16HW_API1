package com.API.CategoriesInfo;

import com.API.model.CategoriesPojo;
import com.API.testbase.TestBase1;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoriesPatch extends TestBase1 {
    @Test
    public void updateCat() {
        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName("Manufacturing");

        Response response = given()
                .log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", "pcmcat748301108075")
                .when()
                .body(categoriesPojo)
                .patch("/{id}");
        response.then().statusCode(200);
    }
}
