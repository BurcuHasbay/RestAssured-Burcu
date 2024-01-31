package com.cybertek.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class HRGetRequest {


    //It runs all the test cases inside this class,
    //It executes one time before everything.
    //So that you don't have to rewrite the same base URL for everything
    @BeforeAll
    public static void init(){
        //Save BASE URL inside this variable so that we don't have to type http method every single time
        RestAssured.baseURI = "http://54.158.33.169:1000/ords/hr";


    }

    @Test
    public void test1(){

        //You can just add the "endpoint". You don't have to write the
        //whole IP address
        Response response = get("/regions");

        System.out.println(response.statusCode());

    }

/*
  Given accept type is json
  When user sends get, request to regions/2
  Then response status code must be 200 and body is
Json format and response body contoins Americas
 */

    @DisplayName("GET Request to /gesions/2")
    @Test
    public void test2(){

        //If you want to see the format IN JSON, you need to tell this as below:

        Response response = given().accept(ContentType.JSON).when().get("/regions/2");
        //Verify Status Code
        assertEquals(200,response.statusCode());

        //Verify Body Contains Americas
        assertTrue(response.body().asString().contains("Americas"));


    }





}
