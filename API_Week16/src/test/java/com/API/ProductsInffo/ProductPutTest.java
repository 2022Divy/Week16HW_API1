package com.API.ProductsInffo;

import com.API.model.ProductsPojo;
import com.API.testbase.TestBase;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductPutTest extends TestBase {

    @Test
    public void updateProduct(){
        ProductsPojo productsPojo = new ProductsPojo();

        productsPojo.setName("Durac");
        productsPojo.setType("Harward");
        productsPojo.setPrice(700);
        productsPojo.setUpc("039900010229");
        productsPojo.setShipping(0);
        productsPojo.setDescription("4-pack AA alkaline batteries");
        productsPojo.setManufacturer("Puma");
        productsPojo.setModel("Tesla");
        productsPojo.setUrl("http://www.bestbuy.com/site/energizer-max-batteries-aa-4-pack/150115.p?id=1051384046217&skuId=150115&cmp=RMXCC");

        given()
                .log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", "9999679")
                .body(productsPojo)
                .when()
                .put("/{id}")
                .then()
                .statusCode(200);
    }
}
