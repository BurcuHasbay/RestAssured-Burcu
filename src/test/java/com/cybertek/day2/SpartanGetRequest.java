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


}
