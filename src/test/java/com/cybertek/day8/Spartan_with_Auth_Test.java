package com.cybertek.day8;

import com.cybertek.utilities.Spartan_AuthTESTBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
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

    @DisplayName("DELETE /api/spartans/{id} as an editor expecting 403")
    @Test
    public void testEditorDelete(){

    given()
            .auth().basic("editor","editor")
            .and().accept(ContentType.JSON)
            .pathParam("id",79)
            .when()
            .delete("/api/spartans/{id}")
            .then()
            .statusCode(403)
            .log().all();

     //As an editor, you are not allowed to
        // delete any spartan, that's why the status code was 403
        // as expected
        /*
        "timestamp": "2024-02-20T12:35:03.281+0000",
    "status": 403,
    "error": "Forbidden",
    "message": "Forbidden",
    "path": "/api/spartans/79"
         */

    }



}
