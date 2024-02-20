package com.cybertek.day8;

import com.cybertek.utilities.Spartan_AuthTESTBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class Spartan_with_Auth_Test extends Spartan_AuthTESTBase {

@DisplayName("GET /api/spartans as a public User (guest) expexting 401")
    @Test
    public void test1(){

//shortest way just for the get request right away

    get("/api/spartans")
            .then().statusCode(401)
            .log().all();

    //The result is
    /*
    "timestamp": "2024-02-20T11:28:30.270+0000",
    "status": 401,
    "error": "Unauthorized",
    "message": "Unauthorized",
    "path": "/api/spartans"
     */




}

    @DisplayName("GET /api/spartans as admin and expect 200")
    @Test
    public void testAdmin(){

    given()
            .auth().basic("admin","admin")
            .and().accept(ContentType.JSON)

            .when()
            .get("/api/spartans")
            .then()
            .statusCode(200);



    }

}
