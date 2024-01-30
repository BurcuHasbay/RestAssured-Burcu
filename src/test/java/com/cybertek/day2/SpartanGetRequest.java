package com.cybertek.day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
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


}

}
