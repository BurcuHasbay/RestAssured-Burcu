package com.cybertek.day10;

import com.cybertek.utilities.Spartan_AuthTESTBase;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class jsonSchemaValidation_test extends Spartan_AuthTESTBase {

    @DisplayName("GET request to /api/spartans/{id} to verify one Spartan against Schema")
    @Test
    public void schemaValidation_Test(){

        given().accept(ContentType.JSON)
                .and().pathParam("id",10)
                .auth().basic("admin","admin")
                .when()
                .get("/api/spartans/{id}")
                .then()
                .statusCode(200)
        //How to verify the response we get against the schema in the resources file
        //RESPONSE VS. SCHEMA FILE IN THE "RESOURCES" DIRECTORY
                //We are not going to call anything
        //INSTEAD..
        //we are going to directly send the file"SingleSpartanSchema"
        //TO compare with the BODY!
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("SingleSpartanSchema.json"))
                .log().all();




    }
}
