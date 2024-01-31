package com.cybertek.day2;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

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

    /*
    Given accept type application/xml
    When user sends GET Request to /api/spartans end point
    Then response Content Type must be application/xml
     */


}
