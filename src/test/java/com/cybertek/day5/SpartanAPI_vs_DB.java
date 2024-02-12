package com.cybertek.day5;

import com.cybertek.utilities.DBUtils;
import com.cybertek.utilities.SpartanTEst_Base;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

import static org.hamcrest.MatcherAssert.assertThat;

public class SpartanAPI_vs_DB extends SpartanTEst_Base {

    @DisplayName("GET one Spartan from API and DATABASE")
    @Test
    public void testDB1(){

        /*
        Get id,name,gender,phone from Database
        Get some information from API
        COMPARE
         */
    //HOW CAN I GET THE INFORMATION FROM DATABASE
        //QUERY
    String query ="Select spartan_id,name,gender,phone from spartans where spartan_id = 15";

    //SAVE DATA INSIDE THE MAP (SHOULD BE STATIC)
        Map<String, Object> dbMap = DBUtils.getRowMap(query);
        System.out.println(dbMap);


        //2-GET THE DATA FROM THE API
        Map <String,Object> apiMap = given().accept(ContentType.JSON).pathParam("id", 15)
                .when()
                .get("/api/spartans/{id}")
                .then()
                .statusCode(200)
                .contentType("application/json")
                .extract().response().as(Map.class);



    }



}
