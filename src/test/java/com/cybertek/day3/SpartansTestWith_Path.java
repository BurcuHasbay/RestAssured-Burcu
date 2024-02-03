package com.cybertek.day3;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpartansTestWith_Path {

    @BeforeAll
    public static void init() {

        //Save BASE URL inside this variable so that we don't have to type http method every single time
        baseURI = "http://54.158.33.169:8000";
    }

    @DisplayName("GET one spartan with PATH Method")
    @Test
    public void test1(){

        /*
Given accept type is json
And path param id is 10
When user sends a get request to "api/spartans/{id}"
Then status code is 200
And content-type is "application/json"
And response payload values match the following: (VERIFY)
id is 10,
name is "Lorenza"
gender is "Female",
phone is 3312820936
         */

        Response response = given().accept(ContentType.JSON).and().pathParam("id", 10).when()
                .get("/api/spartans/{id}");

        assertEquals(200,response.statusCode());
        assertEquals("application/json",response.contentType());

        //Verify each JSON key with specific value
        //IT IS LIKE GET ATTRIBUTE
        //YOU PROVIDE THE KEY, GET THE VALUE IN RETURN = THIS IS HOW PATH WORKS.
        System.out.println(response.path("id").toString());

        System.out.println(response.path("name").toString());

        System.out.println(response.path("gender").toString());

        System.out.println(response.path("phone").toString());

        //HOW CAN I SAVE THOSE VARIABLES WITHOUT CASTING
        int id = response.path("id");
        String name = response.path("name");
        String gender = response.path("gender");
        long phone = response.path("phone");

        System.out.println("id = " + id);
        System.out.println("name = " + name);
        System.out.println("gender = " + gender);
        System.out.println("phone = " + phone);

        //ASSERTION
        assertEquals(10,id);
        assertEquals("Lorenza",name);
        assertEquals("Female",gender);
        assertEquals(3312820936l,phone);


    }





}
