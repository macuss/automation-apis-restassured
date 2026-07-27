package com.alkemy;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
//import io.restassured.response.ValidatableResponse;

public class FindByStatus {

    public static void main(String[] args) {
        System.out.println("Hello, Pet Store!");
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        Response respuesta = given()
                .queryParam("status", "available")
                .log().all()
            .when()
                .get("/pet/findByStatus")
            .then()
            .log().all()
            .statusCode(200)
            .extract().response();
            
        System.out.println(" respuesta Json ");
        System.out.println(respuesta.getBody().asPrettyString());
        System.out.println(" datos adicionales ");
        System.out.println(" status HTTP: " + respuesta.getStatusCode());
        System.out.println(" cantidad de mascotas: " + respuesta.jsonPath().getList("$").size());


    }

    
}
