package com.cybertek.day5;

import com.cybertek.utilities.HR_Test_Base;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class ORDS_HamcrestTest extends HR_Test_Base {


    @DisplayName("GET request to employees IT_PROG endpoint and chaining")
    @Test
    public void employeesTest(){

        /*
        Send a GET request to employees endpoint with query parameter job_id IT_PROG
        Verify each job_id is IT_PROG
        Verify first names are....(find proper method to check list against list)
        Verify emails without checking order (provide emails in different order
        and jut make sure it has the same emails
         */

    given().accept(ContentType.JSON)
            .and().queryParam("q","{\"job_id\":\"IT_PROG\"}")
            .when()
              .get("/employees")
            .then()
               .statusCode(200)
            //JUST LIKE LOOP
               .body("items.job_id",everyItem(equalTo("IT_PROG")));
    }


}
