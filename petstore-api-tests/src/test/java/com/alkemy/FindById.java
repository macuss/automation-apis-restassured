package com.alkemy;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
//import io.restassured.response.ValidatableResponse;

public class FindById {

    public static void main(String[] args) {
        System.out.println("Hello, Pet Store!");
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        long petID = 9223372036854775796L;

        Response respuesta = given()
                .pathParam("petId", petID)
                // .log().all()
            .when()
                .get("/pet/{petId}")
            .then()
            .log().all()
            .statusCode(200)
            .extract().response();
            
        System.out.println(" respuesta Json ");
       // System.out.println(respuesta.getBody().asPrettyString());
        System.out.println(" datos adicionales ");
        System.out.println(" status HTTP: " + respuesta.getStatusCode());
        System.out.println(" nombre de la mascota: " + respuesta.jsonPath().getString("name"));
        System.out.println(" status de la mascota: " + respuesta.jsonPath().getString("status"));
       


    }

    
}
