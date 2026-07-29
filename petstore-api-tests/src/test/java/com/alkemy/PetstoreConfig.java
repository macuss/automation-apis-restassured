package com.alkemy;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class PetstoreConfig {


    public static final String BASE_URL = "https://petstore.swagger.io/v2";

    public static void setup() {
        
        RestAssured.baseURI = BASE_URL;

        RestAssured.filters(
            new RequestLoggingFilter(),
            new ResponseLoggingFilter()
        );
    }
    
}
