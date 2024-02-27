package com.cybertek.day11;

import io.restassured.http.ContentType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class CsvFileSource_ParametrizedTest {

@ParameterizedTest
    @CsvFileSource(resources = "/postalCode.csv",numLinesToSkip = 1)
    public void postalCodeTest_withFile(String stateArg, String cityArg, int zipCountArg){

    System.out.println("stateArg = " + stateArg);
    System.out.println("cityArg = " + cityArg);
    System.out.println("zipCountArg = " + zipCountArg);

    //send a request and verify place number has zipCount

       given().baseUri("https://www.zippopotam.us").accept(ContentType.JSON)
            .and().pathParam("state", stateArg)
            .pathParam("city", cityArg)
            .log().all()
            .when().get("/us/{state}/{city}")
            .then().statusCode(200)
            .body("places",hasSize(zipCountArg));

}




}
