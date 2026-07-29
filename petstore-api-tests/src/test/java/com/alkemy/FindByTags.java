package com.alkemy;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class FindByTags {
    public static void main(String[] args) {
        System.out.println("Hello, Pet Store!");
        PetstoreConfig.setup();



        System.out.println("No se puede buscar por tags, ya que la API no lo permite");

        Response respuesta = given()
            .queryParam("tags", "tag1,tag2")
            .when()
                .get("/pet/findByTags")
            .then()
                .statusCode(404)
                .header("Content-Type", "application/json")
                .extract().response();


        System.out.println(" respuesta Json ");
        System.out.println(respuesta.getBody().asPrettyString());
        System.out.println(" datos adicionales ");  
        System.out.println(" status HTTP: " + respuesta.getStatusCode());
        System.out.println(" cantidad de mascotas: " + respuesta.jsonPath().getList("$").size());

    }

}
