package com.cybertek.day5;

import com.cybertek.utilities.HR_Test_Base;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
        Verify first names are "Alexander", "Bruce", "David", "Valli", "Diana"
        (find proper method to check list against list)
        Verify emails without checking order (provide emails in different order
        and jut make sure it has the same emails
         */

        List<String> names = Arrays.asList("Alexander", "Bruce", "David", "Valli", "Diana");

    given().accept(ContentType.JSON)
            .and().queryParam("q","{\"job_id\":\"IT_PROG\"}")
            .when()
              .get("/employees")
            .then()
               .statusCode(200)
            //JUST LIKE LOOP
               .body("items.job_id",everyItem(equalTo("IT_PROG")))

            //TO GET THE NAMES DIRECTLY
            .body("items.job_id",everyItem(equalTo("IT_PROG")))
            .body("items.first_name",containsInRelativeOrder("Alexander", "Bruce", "David", "Valli", "Diana"))
            .body("items.email",containsInAnyOrder("AHUNOLD","BERNST","DAUSTIN","VPATABAL","DLORENTZ"))
            .body("items.first_name",equalToObject(names));  //Equality of the list assertion


    }


        @Test
        public void employeesTest2(){

        //WE WANT TO MAKE IT CHAIN AND GET THE RESPONSE OBJECT AT THE SAME TIME

            JsonPath jsonPath = given().accept(ContentType.JSON)
                    .and().queryParam("q", "{\"job_id\":\"IT_PROG\"}")
                    .when()
                    .get("/employees")
                    .then()
                    .statusCode(200)
                    //JUST LIKE LOOP
                    .body("items.job_id", everyItem(equalTo("IT_PROG"))).extract()
                    .jsonPath();

            //TO MAKE SURE THAT, WE HAVE ONLY 5 FIRST NAMES
            assertThat(jsonPath.getList("items.first_name"),hasSize(5));

            //ASSERT FIRSTNAMES ORDER
            assertThat(jsonPath.getList("items.email"),containsInRelativeOrder("AHUNOLD","BERNST","DAUSTIN","VPATABAL","DLORENTZ"));


        }

}
