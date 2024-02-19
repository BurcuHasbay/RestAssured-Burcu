package com.cybertek.day7;

import com.cybertek.utilities.SpartanTEst_Base;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class Spartan_POST_req extends SpartanTEst_Base {

    /*
    Given accept type and Content Type is Json
    And request json body is:
   {
    "gender" :"Male",
    "name":"Severus",
    "phone": 8877445594
    }


    When user sends POST request to /api/spartans
    Then StatusCode 201
    And Content type should be application/json
    And Json payload/Response Body should contain:
    "A spartan is Born!" message
    and same data what is posted gender : male ....
     */

/*
We are sending only Json body NOT any params

 */

    @Test
    public void postMethod(){

        String requestJsonBody = "{\n" +
                "    \"gender\": \"Male\",\n" +
                "    \"name\": \"Severus\",\n" +
                "    \"phone\": 99949330313563\n" +
                "}";


        Response response = given().accept(ContentType.JSON).and()
                .contentType(ContentType.JSON)
                .body(requestJsonBody)
                .when()
                .post("/api/spartans");


        assertThat(response.statusCode(),is(201));
        assertThat(response.contentType(),is("application/json"));

        String expectedResponseMessage = "A Spartan is Born!";

        assertThat(response.path("success"),is(expectedResponseMessage));


    }




}
