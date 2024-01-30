package com.cybertek.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpartanGetRequest {


    //According to the Spartans Documentation, this is how you get all the spartans /api/spartans
    String baseUrl = "http://54.158.33.169:8000";

@Test
    public void test2(){

    /*
Given Accept type application/json
When user send GET request to api/spartans endpoint
Then statusCode must be 200
And response Content Type must be application/json
And response body should include spartan result

     */

    Response response = RestAssured.given().accept(ContentType.JSON).when()
            .get(baseUrl + "/api/spartans");

    //Printing status code from the response object
    System.out.println("response.statusCode() = " + response.statusCode());

    //Printing Content Type from the response object
    System.out.println("response.contentType() = " + response.contentType());

    //Printing the whole body
     response.prettyPrint();

     //How to API TESTING then???????
    //Verify statusCode is 200 ok
    Assertions.assertEquals(response.statusCode(),200);


    //Verify Content Type is JSON
    Assertions.assertEquals(response.contentType(),"application/json");


}

    @DisplayName("GET ONE SPARTAN /api/spartans/3")
    @Test
    public void test3(){


    /*
    Given Accept type application/json
When user send GET request to api/spartans endpoint
Then statusCode must be 200
And response Content Type must be application/json 3
And Json body should contain fidole

     */
        Response response = RestAssured.given().accept(ContentType.JSON).when().get(baseUrl + "/api/spartans/3");

        System.out.println("response.statusCode() = " + response.statusCode());

        System.out.println("response.contentType() = " + response.contentType());

        response.prettyPrint();


        Assertions.assertEquals(200,response.statusCode());

        Assertions.assertEquals("application/json",response.contentType());

        Assertions.assertTrue(response.body().asString().contains("Fidole"));

    }


    @DisplayName("GET Request to /api/hello")
    @Test
    public void test4(){

    /*
Given no headers provided
When Users sends GET request to /api/hello.
Then response status code should be 200
And Content type header should be "text/plain;charset=UTF-8"
And header should contain dote
And Content-Length should be 17
And body should be "Hello from Sparta"
     */

        //Send request and save response inside the response Object
        Response response = RestAssured.when().get(baseUrl + "/api/hello");

        Assertions.assertEquals(200,response.statusCode());

        Assertions.assertEquals("text/plain;charset=UTF-8",response.contentType());

        //Verify we have headers named 'Date'

    }


















}
