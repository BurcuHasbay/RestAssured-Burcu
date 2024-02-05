package com.cybertek.day4;

import com.cybertek.utilities.HR_Test_Base;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        System.out.println("response.path(\"hasMore\") = " + response.path("hasMore"));

        //PRINT FIRST COUNTRY ID
        String firstCountryID = response.path("items[0].country_id");
        System.out.println("firstCountryID = " + firstCountryID);

        //PRINT THE SECOND COUNTRY NAME
        String secondCountryName = response.path("items[1].country_name");
        System.out.println("secondCountryName = " + secondCountryName);


        //PRINT "http://54.158.33.169:1000/ords/hr/countries/CA"
        String CALink = response.path("items[2].links[0].href");
        System.out.println("CALink = " + CALink);

        //GET ME ALL COUNTRY NAMES
        List<String> countryNames = response.path("items.country_name");
        System.out.println("countryNames = " + countryNames);

        //ASSERT THAT ALL REGIONS IDS ARE EQUAL TO 2.
        List<Integer> allRegionsIDs= response.path("items.region_id");
        for (Integer eachRegionId : allRegionsIDs) {

            System.out.println("eachRegionId = " + eachRegionId);
            assertEquals(2,eachRegionId);


        }


    }

    @DisplayName("GET request to /employees with QUERY PARAM")
    @Test
    public void test2(){

        Response response = given().accept(ContentType.JSON).and().
                queryParam("q", "{\"job_id\":\"IT_PROG\"}").
                when().get("/employees");

        assertEquals(200,response.statusCode());
        assertEquals("application/json",response.contentType());
        assertTrue(response.body().asString().contains("IT_PROG"));

        //MAKE SURE WE HAVE ONLY IT_PROG AS A JOB ID
        List<String>allJobIDs=response.path("items.job_id");
        System.out.println("allJobIDs = " + allJobIDs);




    }

}
