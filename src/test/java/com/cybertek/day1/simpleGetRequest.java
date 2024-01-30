package com.cybertek.day1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class simpleGetRequest {

    String url = "http://54.158.33.169:8000/api/spartans";

    @Test
    public void test(){

        //send a request and save response inside the Response Object
        Response response = RestAssured.get(url);

        //Print response STATUS CODE
        System.out.println(response.statusCode());

        //Print RESPONSE BODY
        response.prettyPrint();


    }
}
