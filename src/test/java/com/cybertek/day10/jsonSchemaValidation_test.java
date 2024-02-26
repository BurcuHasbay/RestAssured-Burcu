package com.cybertek.day10;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class jsonSchemaValidation_test {

    @DisplayName("GET request to /api/spartans/{id} to verify one Spartan against Schema")
    @Test
    public void schemaValidation_Test(){

        given().accept(ContentType.JSON)
                .and().pathParam("id",10)
                .auth().basic("adming","adming")
                .when()
                .get("/api/spartans/{id}")
                .then()
                .statusCode(200);




    }
}
