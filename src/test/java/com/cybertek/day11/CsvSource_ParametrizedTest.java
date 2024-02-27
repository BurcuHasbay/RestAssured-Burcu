package com.cybertek.day11;

import io.restassured.http.ContentType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class CsvSource_ParametrizedTest {

    /*
    Test first number + second number = third number
    1,3,4
    2,3,5
    8,7,15
    10,9,19
     */

    @ParameterizedTest
    @CsvSource({"1, 3 , 4",
            "2, 3 , 5",
            "8, 7 , 15",
            "10, 9 , 19"})
    public void testAddition(int num1, int num2, int sum) {

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        System.out.println("sum = " + sum);

        assertThat(num1 + num2, equalTo(sum));


    }

    /*
    Write a parametrized test for this request
    Get https://www.zippopotam.us /us{state}/{city}
    "NY, New York"
    "CO, Denver",
    "VA, Fairfax",
    "MA, Boston",
    "NY, New York
    "MD Annapolis",

    Verify a place name that contains a city name
    Print number of places for each request

     */

    @ParameterizedTest
    @CsvSource({"NY, New York",
            "CO, Denver",
            "VA, Fairfax",
            "MA, Boston",
            "NY, New York",
            "MD, Annapolis"})
    public void zipCodeMultiInputTest(String state, String city) {
        System.out.println("state = " + state);
        System.out.println("city = " + city);

        int placeNumber
                = given().baseUri("https://www.zippopotam.us").accept(ContentType.JSON)
                .and().pathParam("state", state)
                .pathParam("city", city)
                .log().all()
                .when().get("/us/{state}/{city}")
                .then().statusCode(200)
                .body("places.'place name'", everyItem(containsString(city)))
                .extract().jsonPath().getList("places").size();

        //Verify each (everyItem) place name that contains a city name
        //ABOVE! in body, we can use matchers

        //Print number of places for each request
        //ABOVE-needs arrayList-jsonPath().getList("places").size();


    }
}
