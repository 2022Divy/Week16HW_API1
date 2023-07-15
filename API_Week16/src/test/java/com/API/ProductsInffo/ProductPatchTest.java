package com.API.ProductsInffo;

import com.API.model.ProductsPojo;
import com.API.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductPatchTest extends TestBase {
    @Test
    public void patchProducts() {
        ProductsPojo productsPojo = new ProductsPojo();
        productsPojo.setPrice(300);


        given()
                .log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", "9999679")
                .body(productsPojo)
                .when()
                .patch("/{id}")
                .then()
                .statusCode(200);
    }
}