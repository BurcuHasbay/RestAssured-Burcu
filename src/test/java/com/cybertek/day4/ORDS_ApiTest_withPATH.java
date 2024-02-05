package com.cybertek.day4;

import com.cybertek.utilities.HR_Test_Base;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
public class ORDS_ApiTest_withPATH extends HR_Test_Base {

    @DisplayName("GET request to countries with Path Method")
    @Test
    public void test1(){


        Response response = given().accept(ContentType.JSON).and().
                      queryParam("q", "{\"region_id\":2}").
                when().get("/countries");


        assertEquals(200,response.statusCode());

        //HOW CAN I DIRECTLY GET THE LIMIT (IT IS 25)
        //PRINT 'LIMIT' RESULT
        //IN THE PATH PARAMETERS, YOU GIVE THE KEY "LIMIT", IT GIVES YOU  AUTOMATICALLY THE VALUE OF THE KEY
        System.out.println("response.path(\"limit\") = " + response.path("limit"));


        //PRINT 'HASMORE'
        //JUST GIVE THE KEY
        System.out.println("response.path(\"hasmore\") = " + response.path("hasmore"));

        //PRINT FIRST COUNTRY ID
        String firstCountryID = response.path("item[0].country_id");
        System.out.println("firstCountryID = " + firstCountryID);


    }


}
