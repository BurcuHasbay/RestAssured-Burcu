package com.cybertek.day5;

import com.cybertek.utilities.SpartanTEst_Base;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class JSON_to_Java_Test extends SpartanTEst_Base {

    @DisplayName("GET one Spartan and Deserialize to MAp")
    @Test
    public void oneSpartanToMap(){

        Response response = given().pathParam("id", 15)
                            .when().get("/api/spartans({id}")
                            .then()
                             .statusCode(200).extract().response();


    }


}
