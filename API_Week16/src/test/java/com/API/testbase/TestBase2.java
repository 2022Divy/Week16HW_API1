package com.API.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class TestBase2 {
    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI="http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath ="/stores";

    }
}
