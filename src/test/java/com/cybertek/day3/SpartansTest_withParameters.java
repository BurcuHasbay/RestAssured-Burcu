package com.cybertek.day3;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

        @DisplayName("GET request to api/spartans/search with QUERY PARAMS")
        @Test
        public void test3(){

            /*
     Given-accept type is Json

     And query parameter values are:
     gender| Female
     nameContains /e

     When user sends GET request to /api/spartans/search
     Then response status code should be 200
     And response content-type: "application/json"
     And "Female" should be in response payload
     And "Janette" should be in response payload
             */

            Response response = given().log().all().
                    accept(ContentType.JSON).and().
                    queryParam("nameContains", "e")
                    .and().queryParam("gender", "Female")
                    .when().get("/api/spartans/search");


            assertEquals(200,response.statusCode());

            assertEquals("application/json",response.contentType());

            assertTrue(response.body().asString().contains("Female"));

            assertTrue(response.body().asString().contains("Janette"));


        }

    @DisplayName("GET request to api/spartans/search with QUERY PARAMS (MAP")
    @Test
    public void test4(){

//CREATE A MAP and  ADD QUERY PARAMETERS
        Map<String, Object> queryMap = new HashMap<>();
        //nameContains= KEY,  e = VALUE
        queryMap.put("nameContains","e");
        queryMap.put("gender","Female");

        Response response = given().log().all().accept(ContentType.JSON).and().
                queryParams(queryMap).when().
                get("/api/spartans/search");



        assertEquals(200,response.statusCode());

        assertEquals("application/json",response.contentType());

        assertTrue(response.body().asString().contains("Female"));

        assertTrue(response.body().asString().contains("Janette"));




    }



}

