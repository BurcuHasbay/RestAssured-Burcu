package com.cybertek.day10;

import com.cybertek.utilities.Spartan_AuthTESTBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class ResponseTimeTest extends Spartan_AuthTESTBase {

    @Test
    public void responseTimeTest(){

        //What if you want to verify your response's time?

        Response response = given()
                .auth().basic("admin", "admin")
                .accept(ContentType.JSON)
                .when()
                .get("/api/spartans")
                        .then().time(both(greaterThan(500L)).and(lessThan(2000L)))
                        .extract().response();

        //Get the Response inside the Response Object

        System.out.println("response.getTime() = " + response.getTime());

        //HOW CAN YOU VERIFY THAT THIS AMOUNT OF TIME IS BETWEEN the RANGE OF ??
        //Should be ranging between some certain amount of time
        //lessThan and greaterThan should be together
        //both :D (both(greaterThan(500L)).and(lessThan(2000L)))



    }

}
