package com.alkemy;

import io.restassured.response.Response;
import net.datafaker.Faker;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CreatePetConMap {
    public static void main(String[] args) {
        PetstoreConfig.setup();

        Faker faker = new Faker(Locale.forLanguageTag("es"));
        long id = System.currentTimeMillis();
        String nombre = faker.animal().name();
        String categoria = faker.animal().name();
        String fotoUrl = "https://example.com/pets/" + nombre.toLowerCase() + ".jpg";
        String status = faker.options().option("available", "pending", "sold");

        Map<String, Object> category = new HashMap<>();
        category.put("id", faker.number().numberBetween(1, 100));
        category.put("name", categoria);

        Map<String, Object> mascota = new HashMap<>();
        mascota.put("id", id);
        mascota.put("name", nombre);
        mascota.put("photoUrls", List.of(fotoUrl));
        mascota.put("status", status);
        mascota.put("category", category);

        System.out.println("--- Payload armado con Map + Faker ---");
        System.out.println(mascota);

        Response respuesta = given()
                .contentType("application/json")
                .body(mascota)
                .when()
                .post("/pet")
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .extract().response();

        System.out.println("\n--- Datos puntuales ---");
        System.out.println("Status HTTP: " + respuesta.getStatusCode());
        System.out.println("ID enviado: " + id);
        System.out.println("ID en respuesta: " + respuesta.jsonPath().getLong("id"));
        System.out.println("Nombre enviado: " + nombre);
        System.out.println("Nombre en respuesta: " + respuesta.jsonPath().getString("name"));
        System.out.println("Estatus: " + respuesta.jsonPath().getString("status"));

    }
}
