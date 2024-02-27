package com.cybertek.day11;

import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class Parametrized_Junit5 {

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,5,7,8,10,5}) //based on the size of numbers provided, it gets executed that time

    public void testMultipleNumbers(int number){

        System.out.println(number);
        Assertions.assertTrue(number==8);

    }

    @ParameterizedTest
    @ValueSource(strings = {"John","Abba","TJ","Gigi"})
    public void testMultiple(String name){
        System.out.println("name = " + name);
    }



    @ParameterizedTest
    @ValueSource(ints = {01000,02000,03000,04000,05000,06000,35000,63000,64000})
   public void testMultipleCities(int zipCode){
      given().baseUri("https://www.zippopotam.us")
                .and().pathParam("zipcode", zipCode).log().all()
                .when().get("/TR/{zipcode}")
                .then().statusCode(200);


    }

    /*
    Send a get request to  http://www.zippopotam.us 01000,02000,03000,04000,05000,06000,35000,63000,64000
    with these zipcodes to Pathparam
    Check status code 200
     */


}
