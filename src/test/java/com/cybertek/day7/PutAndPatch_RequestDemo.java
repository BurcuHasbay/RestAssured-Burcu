package com.cybertek.day7;
import com.cybertek.utilities.SpartanTEst_Base;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class PutAndPatch_RequestDemo extends SpartanTEst_Base {

    @DisplayName("PUT request to one spartan to UPDATE with MAP")
    @Test
    public void PUTRequest() {

        Map<String, Object> putRequestMap = new LinkedHashMap<>();
        putRequestMap.put("name", "BruceWayne");
        putRequestMap.put("gender", "Male");
        putRequestMap.put("phone", 3750699867L);

        given().contentType(ContentType.JSON)//HEY API, I'M SENDING JSON BODY
                .body(putRequestMap).and().pathParam("id", 108)
                .put("/api/spartans/{id}")
                .then()
                .statusCode(204);

    }


    @DisplayName("PATCH request to one spartan to UPDATE with MAP")
    @Test
    public void PATCHRequest() {

        Map<String, Object> patchRequestMap = new LinkedHashMap<>();
        patchRequestMap.put("name", "Lilly");
        patchRequestMap.put("gender", "Female");

        given().contentType(ContentType.JSON)//HEY API, I'M SENDING JSON BODY
                .body(patchRequestMap).and().pathParam("id", 108)
                .patch("/api/spartans/{id}")
                .then()
                .statusCode(204);

    }


    @DisplayName("PUT request to one spartan to UPDATE with MAP")
    @Test
    public void PUTRequestMAP() {

        Map<String, Object> putRequestMap = new LinkedHashMap<>();
        putRequestMap.put("name", "Lilly");
        putRequestMap.put("gender", "Female");
        putRequestMap.put("phone", 3737099867L);

        given().contentType(ContentType.JSON)//HEY API, I'M SENDING JSON BODY
                .body(putRequestMap).and().pathParam("id", 114)
                .patch("/api/spartans/{id}")
                .then()
                .statusCode(204);
    }

//HOW TO DELETE A SPARTAN

    @DisplayName("DELETE one spartan")
    @Test
    public void deleteSpartan(){

        Integer iDToDelete = 48;

        given().pathParam("id",iDToDelete)
                .when().delete("/api/spartans/{id}")
                .then().statusCode(204);

        //SEND a GET request To MAKE SURE YOU GET 404

        given().pathParam("id",iDToDelete)
                .when().get("/api/spartans/{id}")
                .then().statusCode(404);

    }










}








/*
Homework:

//SEND A GET REQUEST. THEN UPDATE
MAKE SURE UPDATED FIELD CHANGED OR THE NEW INFO MATCHES
WITH THE requestBODY THAT WE SENT
 */


