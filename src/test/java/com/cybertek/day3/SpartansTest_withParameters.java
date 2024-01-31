package com.cybertek.day3;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpartansTest_withParameters {

    @BeforeAll
    public static void init() {
        //Save BASE URL inside this variable so that we don't have to type http method every single time
        RestAssured.baseURI = "http://54.158.33.169:8000";

    }



        /*

  Given accept type is Json
  And ID parameter is 5
  When user sends GET Request to /api/spartans/{id}
  Then response status code should be 200
  And response Content Type: application/json
  And "Blythe" should be in response payload

         */

        @DisplayName("GET request to /api/spartans/{id} with ID 5")
        @Test
        public void test1(){

            Response response = given().accept(ContentType.JSON).and().
                    pathParam("id", 5).when().
                    get("/api/spartans/{id}");


            //verify status code
             assertEquals(200,response.statusCode());
             //verify Content Type
             assertEquals("application/json",response.contentType());
             //Verify "Blythe" name in the Json Payload = body
             assertTrue(response.body().asString().contains("Blythe"));




        }

        @DisplayName("GET request to /api/spartans/{id} NEGATIVE TEST")
        @Test
        public void test2(){
            /*
        TASK
     Given accept type is Json
     And Id parameter value is 500
     When user sends GET request to /api/spartans/{id}
     Then response status code should be 404
     And response content-type: application/json
     And "Not Found" message should be in response payload
         */

            Response response = given().accept(ContentType.JSON).
                    and().pathParam("id", 500).
                    get("/api/spartans/{id}");

            //Verify status code
            assertEquals(404,response.statusCode());

            //Verify Content Type is application/json
            assertEquals("application/json",response.contentType());

            //Verify "Not Found" in the Json payload/body
            assertTrue(response.body().asString().contains("Not Found"));




        }



}

