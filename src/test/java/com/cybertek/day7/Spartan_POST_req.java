package com.cybertek.day7;

import com.cybertek.utilities.SpartanTEst_Base;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

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
                "            \"id\": 2,\n" +
                "            \"name\": \"Dolores\",\n" +
                "            \"gender\": \"Female\",\n" +
                "            \"phone\": 42189555448\n" +
                "        }";


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

    @DisplayName("POST with MAP to JSON")
    @Test
    public void postMethod2(){

        //CREATE A MAP TO KEEP REQUEST JSON BODY INFORMATION
        //TO STORE
        Map<String,Object> requestJsonMap
                = new LinkedHashMap<>();
        requestJsonMap.put("name","Dudley");
        requestJsonMap.put("gender","Male");
        requestJsonMap.put("phone"," 8877444975");

        Response response = given().accept(ContentType.JSON).and()
                .contentType(ContentType.JSON)
                .body(requestJsonMap).log().all()
                .when()
                .post("/api/spartans");


        assertThat(response.statusCode(),is(201));
        assertThat(response.contentType(),is("application/json"));

        String expectedResponseMessage = "A Spartan is Born!";

        assertThat(response.path("success"),is(expectedResponseMessage));

        response.prettyPrint();

    }

    @DisplayName("POST with MAP to Spartan")
    @Test
    public void postMethod3(){

        //CREATE A MAP TO KEEP REQUEST JSON BODY INFORMATION
        //TO STORE
        Map<String,Object> requestJsonMap
                = new LinkedHashMap<>();
        requestJsonMap.put("name","Dudley");
        requestJsonMap.put("gender","Male");
        requestJsonMap.put("phone"," 8877444975");

    //--HOW CAN I CREATE SPARTAN API without API




        Response response = given().accept(ContentType.JSON).and()
                .contentType(ContentType.JSON)
                .body(requestJsonMap).log().all()
                .when()
                .post("/api/spartans");


        assertThat(response.statusCode(),is(201));
        assertThat(response.contentType(),is("application/json"));

        String expectedResponseMessage = "A Spartan is Born!";

        assertThat(response.path("success"),is(expectedResponseMessage));

        response.prettyPrint();

    }
}
