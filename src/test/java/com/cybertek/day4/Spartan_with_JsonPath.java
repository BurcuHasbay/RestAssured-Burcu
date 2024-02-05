package com.cybertek.day4;

import com.cybertek.utilities.SpartanTEst_Base;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class Spartan_with_JsonPath extends SpartanTEst_Base {

           /*
Given accept type is json
And path param id is 10
When user sends a get request to "api/spartans/{id}"
Then status code is 200
And content-type is "application/json"
And response payload values match the following: (VERIFY)
id is 10,
name is "Lorenza"
gender is "Female",
phone is 3312820936
         */

    @DisplayName("GET one spartan with JSONPATH")
    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON).and().pathParam("id", 10).when()
                .get("/api/spartans/{id}");

        assertEquals(200,response.statusCode());
        assertEquals("application/json",response.contentType());


        //PRINT name with PATH method
        System.out.println(response.path("name").toString());

        //ASSIGNING RESPONSE TO JsonPATH
        //You are taking response body and putting it into JsonPath Object
        JsonPath jsonPath = response.jsonPath();




    }
}
