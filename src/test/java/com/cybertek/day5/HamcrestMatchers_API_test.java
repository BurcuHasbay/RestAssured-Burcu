package com.cybertek.day5;
import com.cybertek.utilities.SpartanTEst_Base;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class HamcrestMatchers_API_test extends SpartanTEst_Base {

@DisplayName("One Spartan with HAMCREST and Chaining")
    @Test
    public void test1(){

    /*
    Given accept type is Json
    And path param id is 15
    When user sends a get request to /api/spartans/{id}
    Then status Code is 200
    And Content Type is Json
    And Json data has following
    "id": 15,
    "name": "Meta,
    "gender": Meta
    "phone":1938695106
     */

    given().accept(ContentType.JSON)
            .and().pathParam("id",15)
            .when()
                  .get("/api/spartans/{id}")
            .then()
                   .statusCode(200).
            and().
                    contentType("application/json").
            body("id",equalTo(15),
                    "name",is("Meta"),
                    "gender",is( "Female"),
                    "phone",is(1938695106));








}




}
