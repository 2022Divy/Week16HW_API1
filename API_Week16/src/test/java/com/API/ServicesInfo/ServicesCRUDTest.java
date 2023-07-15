package com.API.ServicesInfo;

import com.API.model.CategoriesPojo;
import com.API.model.ServicePojo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ServicesCRUDTest {
    static int idNumber;
    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI="http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath ="/services";

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
        ServicePojo servicePojo = new ServicePojo();

        servicePojo.setName("Catering services");


        Response response = given()
                .log().all()
                .header("Content-Type", "application/json")
                .when()
                .body(servicePojo)
                .post();
        response.then().statusCode(400);

    }
    @Test
    public void updateSer() {
        ServicePojo servicePojo = new ServicePojo();

        servicePojo.setName("Domain Ser");


        Response response = given()
                .log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", "1")
                .when()
                .body(servicePojo)
                .patch("/{id}");
        response.then().statusCode(200);
    }
    @Test
    public void deleteSer() {
        Response response = given()
                .log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", "2")
                .when()
                .delete("/{id}");
        response.then().statusCode(200);
    }
    @Test
    public void retrve() {
        Response response = given()
                .log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", "2")
                .when()
                .get("/{id}");
        response.then().statusCode(404);

    }
}
