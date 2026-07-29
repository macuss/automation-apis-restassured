package com.alkemy;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class StoreInventary {
    
    public static void main(String[] args) {
        System.out.println("Hello, Pet Store!");
        PetstoreConfig.setup();

        System.out.println("No se puede buscar por inventario, ya que la API no lo permite");


        Response respuesta = given()
            .when()
                .get("/store/inventory")
            .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .extract().response();

            
        System.out.println(" respuesta Json ");
        System.out.println(respuesta.getBody().asPrettyString());
        System.out.println(" datos adicionales ");
        System.out.println(" status HTTP: " + respuesta.getStatusCode());

    }
}
