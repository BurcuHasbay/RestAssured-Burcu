package com.cybertek.day5;

import com.cybertek.utilities.SpartanTEst_Base;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class Spartans_HamcrestTest extends SpartanTEst_Base {

    @DisplayName("GET request to spartan/search and chaining together")

    @Test
    public void spartanTest(){

        //Along with this statement, I want to save names inside the List<String>

    List<String> names = given().accept(ContentType.JSON).
                and().
                queryParams("nameContains","j",
                "gender","Male")
        .when().get("api/spartans/search")
         .then()
                //-----------------------------
                .statusCode(200)
                .contentType("application/json")
                .header("Transfer-Encoding",is("chunked")).body("totalElement",is(3)).
                extract().response().jsonPath().getList("content.name");

        System.out.println(names);

    }


}
