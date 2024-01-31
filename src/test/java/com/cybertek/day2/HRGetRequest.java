package com.cybertek.day2;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        Response response = RestAssured.get("/regions");

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

        Response response = RestAssured.get("/regions/2");

        //Verify Status Code
        Assertions.assertEquals(200,response.statusCode());

        //Verify the Content Type
        Assertions.assertEquals("application/json",response.contentType());


        //Verify Body Contains Americas
        Assertions.assertEquals(response.body().asString().contains("Americas"),true);


    }





}
