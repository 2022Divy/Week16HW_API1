package com.API.ServicesInfo;

import com.API.model.ServicePojo;
import com.API.testbase.TestBase3;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ServicesPatchTest extends TestBase3 {
@Test
    public void PatchTest(){
    ServicePojo servicePojo = new ServicePojo();
    servicePojo.setName("VidhiDP");

     given()
             .log().all()
            .header("Content-Type", "application/json")
            .pathParam("id",2)
            .body(servicePojo)
            .when()
            .patch("/{id}")
            .then()
             .statusCode(200)
             .log().all();
}
}
