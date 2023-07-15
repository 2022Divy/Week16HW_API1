package com.API.ProductsInffo;

import com.API.model.ProductsPojo;
import com.API.testbase.TestBase;
import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class ProductPostTest extends TestBase {

    @Test
    public void createProduct(){
        ProductsPojo productsPojo = new ProductsPojo();

        productsPojo.setName("Durac");
        productsPojo.setType("Harward");
        productsPojo.setPrice(699);
        productsPojo.setUpc("039900011229");
        productsPojo.setShipping(0);
        productsPojo.setDescription("4-pack AA alkaline batteries");
        productsPojo.setManufacturer("Puma");
        productsPojo.setModel("Tesla");
        productsPojo.setUrl("http://www.bestbuy.com/site/energizer-max-batteries-aa-4-pack/150115.p?id=1051384046217&skuId=150115&cmp=RMXCC");

        given()
                .log().all()
                .header("Content-Type", "application/json")
                .body(productsPojo)
                .when()
                .post()
                .then()
                .statusCode(201);

    }
}
