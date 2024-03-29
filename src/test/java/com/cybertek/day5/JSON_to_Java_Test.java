package com.cybertek.day5;

import com.cybertek.utilities.SpartanTEst_Base;
import io.restassured.response.Response;
import org.apache.http.conn.util.DnsUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class JSON_to_Java_Test extends SpartanTEst_Base {

    @DisplayName("GET one Spartan and Deserialize to MAp")
    @Test
    public void oneSpartanToMap(){

        Response response = given().pathParam("id", 15)
                            .when().get("/api/spartans/{id}")
                            .then()
                             .statusCode(200).extract().response();

        //GET THE JSON and then CONVERT it to the MAP !!

        Map<String,Object>jsonMap = response.as(Map.class);
        System.out.println(jsonMap);

        //After we got the map, we can use Hamcrest or Junit assertion to do the assertion

        String actualName = (String) jsonMap.get("name");
        assertThat(actualName,is("Meta"));


    }


    @DisplayName("GET all the spartans to JAVA data structure")
    @Test
    public void getAllSpartans(){

        //shortest way for the get request and then save inside the response
        Response response = get("/api/spartans").then().statusCode(200).extract().response();

        //THis time, put this response inside the one data structure
        //the result looks like a map inside each object
        //for one Json Object, we use ONE MAP
        //for MULTIPLE Json Objects, we use LIST OF MAP
        // we need to convert Json to JAVA which is deserialization

        //WHERE YOU DO CONVERSION IS API
        //THI IS API
        List<Map<String,Object>> jsonList = response.as(List.class);

        System.out.println(jsonList.get(1).get("name"));

        //To get individual spartan for example : spartan 3

        //THIS IS JAVA
        Map<String,Object> spartan3 = jsonList.get(2);
        System.out.println(spartan3);


    }

}
