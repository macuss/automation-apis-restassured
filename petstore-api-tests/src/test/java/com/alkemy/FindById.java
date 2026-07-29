package com.alkemy;

//import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
//import io.restassured.response.ValidatableResponse;

public class FindById {

    public static void main(String[] args) {
        System.out.println("Hello, Pet Store!");
        PetstoreConfig.setup();

        long petID = 9223372036854775735L;

        Response respuesta = given()
                .pathParam("petId", petID)
                .when()
                .get("/pet/{petId}")
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .extract().response();

        System.out.println(" respuesta Json ");
        // System.out.println(respuesta.getBody().asPrettyString());
        System.out.println(" datos adicionales ");
        System.out.println(" status HTTP: " + respuesta.getStatusCode());
        System.out.println(" nombre de la mascota: " + respuesta.jsonPath().getString("name"));
        System.out.println(" status de la mascota: " + respuesta.jsonPath().getString("status"));
        System.out.println(" categoria de la mascota: " + respuesta.jsonPath().getString("category.name"));

    }

}
