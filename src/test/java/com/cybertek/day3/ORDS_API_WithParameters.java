package com.cybertek.day3;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class ORDS_API_WithParameters {

        @BeforeAll
        public static void init(){


            //Save BASE URL inside this variable so that we don't have to type http method every single time
           baseURI = "http://54.158.33.169:1000/ords/hr";


           /*
Given accept type is Json
And parameters: q = {"region_id":2}
When users sends a GET request to "/countries"
Then status code is 200
And Content type is application/json
And Payload should contain “United States of America”
            */

        }


        @DisplayName("GET request to /countries with QUERY PARAM")
        @Test
        public void test1(){

            Response response = given().accept(ContentType.JSON).and().
                    queryParam("q", "{\"region_id\":2}").
                    when().get("/countries");


            assertEquals(200,response.statusCode());

            assertEquals("application/json",response.contentType());

            //HOW TO GET A HEADER NAME
            //assertEquals("application/json",response.header("Content-Type"));

            assertTrue(response.body().asString().contains("United States of America"));





        }





}
