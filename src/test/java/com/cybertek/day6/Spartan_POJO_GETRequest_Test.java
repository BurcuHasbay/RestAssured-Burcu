package com.cybertek.day6;

import com.cybertek.utilities.SpartanTEst_Base;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class Spartan_POJO_GETRequest_Test extends SpartanTEst_Base {


@DisplayName("GET one spartan and CONVERT it to SPARTAN OBJECT")
    @Test
    public void oneSpartanPojo(){

/*
First send a GET request to ONE spartan
Save it inside Response Object
Then create convert one spartan Object from spartanClass
*/

    Response response = given().accept(ContentType.JSON).
            and().
            pathParam("id", 15).
            when()
            .get("/api/spartans/{id}")
            .then()
            .statusCode(200).contentType("application/json")
            .extract().response();

    //Deserialize <<>> JSON TO POJO (JAVA CUSTOM CLASS)
    //2 DIFFERENT WAYS FOR THIS
    //1.USING as() METHOD





}







}
