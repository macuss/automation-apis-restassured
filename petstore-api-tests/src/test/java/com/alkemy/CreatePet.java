package com.alkemy;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
public class CreatePet {
    
    public static void main(String[] args) {
        System.out.println("Hello, Pet Store!");
        PetstoreConfig.setup();

        System.out.println("No se puede crear una mascota, ya que la API no lo permite");
        //body del POST: JSON con los datos de la mascota a crear
        String mascota = """
            {
                "id" : %d,
                "name" : "firulais",
                "photoUrls" : ["https://example.com/firulais.jpg"],
                "status" : "available",
                "category" : {
                    "id" : 1,
                    "name" : "perros"
            }
                """.formatted(System.currentTimeMillis());

        Response respuesta = given()
            .contentType("application/json")
            .body(mascota)
            .when()
                .post("/pet")
            .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .extract().response();


        System.out.println(" respuesta Json ");
        System.out.println(respuesta.getBody().asPrettyString());
    }
}
