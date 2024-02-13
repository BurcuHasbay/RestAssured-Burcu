package com.cybertek.day6;

import com.cybertek.Pojos.Region;
import com.cybertek.utilities.HR_Test_Base;
import io.restassured.path.json.JsonPath;
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
        System.out.println("R1.getRegion_id() = " + R1.getRegion_id());


    }
}
