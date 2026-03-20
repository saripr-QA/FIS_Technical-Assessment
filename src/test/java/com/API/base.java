package com.API;

import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;

public class base {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://api.coingecko.com/api/v3";
        RestAssured.useRelaxedHTTPSValidation();
    }
}