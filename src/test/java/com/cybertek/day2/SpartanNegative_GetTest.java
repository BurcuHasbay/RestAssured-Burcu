package com.cybertek.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpartanNegative_GetTest {


    //It runs all the test cases inside this class,
    //It executes one time before everything.
    //So that you don't have to rewrite the same base URL for everything
    @BeforeAll
    public static void init(){
        //Save BASE URL inside this variable so that we don't have to type http method every single time
        RestAssured.baseURI = "http://54.158.33.169:8000";


    }

    @DisplayName("Get Request to /api/spartans/10")
    @Test
    public void test1(){

        Response response = given().accept(ContentType.XML).when().get("/api/spartans/10");


        //Verify that the status code is 406
        assertEquals(406,response.statusCode());

        //Verify that the content type is application/xml (But it is not)

        assertEquals("application/xml;charset=UTF-8",response.contentType());



    }

    /*
    Given accept type application/xml
    When user sends GET Request to /api/spartans/10 end point
    Then status code must be 406 ok
    Then response Content Type must be application/xml
     */


}
