package com.cybertek.day5;
import com.cybertek.utilities.Cyber_Base;
import com.cybertek.utilities.SpartanTEst_Base;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class HamcrestMatchers_API_test extends Cyber_Base {

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
            //REQUEST PART
            //------------------------------------
            //RESPONSE PART
            .then()
                   .statusCode(200).
            and().
                    contentType("application/json").
            body("id",equalTo(15),
                    "name",is("Meta"),
                    "gender",is( "Female"),
                    "phone",is(1938695106));


}

        @DisplayName("HamcrestMatcher and Chaining")
        @Test
        public void test2(){
/*
    teacher id is 2
    status code 200
    content type Json
    Response content type is application/json;charset=UTF-8
                "emailAddress": "ron@mail.com",
            "firstName": "Ron",
            "salary": 100000,
            "birthDate": "07/20/1983",

   VERIFY current date in RESPONSE HEADERS is Wed, 07 Feb 2024 12:07:11 GMT
     */

            given().accept(ContentType.JSON)
                    .and()
            .pathParam("id",2)
                    .when()
            .get("/teacher/{id}")
                    .then()
                    .statusCode(200)
                    .and()
                    .contentType("application/json;charset=UTF-8")
                    //.header("date",is("Wed, 07 Feb 2024 12:07:11 GMT"))
                    .header("date",notNullValue())
                    .body("firstName",is("Ron"),
                            "emailAddress",is("ron@mail.com"),
                            "salary",equalTo(100000),
                            "birthDate",is("07/20/1983"));

        }



}
