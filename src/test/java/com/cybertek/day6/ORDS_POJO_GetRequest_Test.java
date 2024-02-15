package com.cybertek.day6;

import com.cybertek.Pojos.Employee;
import com.cybertek.Pojos.Link;
import com.cybertek.Pojos.Region;
import com.cybertek.utilities.HR_Test_Base;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class ORDS_POJO_GetRequest_Test extends HR_Test_Base {
    /*

    Create Pojo classes for this response
    Then test it by sending get request to regions endpoint
    And only pointing first region and converting your Pojos


     */

    @Test
    public void regionTest(){

        JsonPath jsonPath = get("/regions").then().statusCode(200).contentType("application/json")
                .extract().jsonPath();

        Region R1 = jsonPath.getObject("items[0]", Region.class);

        System.out.println(R1);
        System.out.println("R1.getRegion_name() = " + R1.getRegion_name());
        System.out.println("R1.getRegion_id() = " + R1.getRegionId());
        System.out.println("R1.getLinks().get(0).getHref() = " + R1.getLinks().get(0).getHref());



    }

    /*
SCENARIO:
You have json which has a lot of keys and values, but you just need
first 4 values to do verification, how can you only get 4 values
 randomly (doesn't matter which value) and ignore the rest of them.

 */

    @DisplayName("GET request to /employees and only get a few of the values as POJO class")
    @Test
    public void employeeGet(){

        Employee employee1
                = get("/employees").then()
                .statusCode(200)
                .contentType("application/json")
                .extract().jsonPath().getObject("items[0]", Employee.class);


        System.out.println(employee1);


    }


    /*
    // SEND A GET REQUEST TO REGIONS
    //VERIFY THAT REGION IDs ARE 1,2,3,4
    //VERIFY THAT REGIONS' NAMES ARE Europe,Americas,Asia,Middle East and
    Africa
    //VERIFY THAT TOTAL IS 4
    TRY TO USE POJO AS MUCH AS POSSIBLE
    IGNORE NON-USED FIELDS
     */

    @DisplayName("Get request to /regions and verify id numbers and regions' names and total 4,ignore the rest")
    @Test
    public void region4PojoTest(){

        Region regions = get("/regions").then().statusCode(200).contentType("application/json")
                .extract().as(Region.class);


    }




}
