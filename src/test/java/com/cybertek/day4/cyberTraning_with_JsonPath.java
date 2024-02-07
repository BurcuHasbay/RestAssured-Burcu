package com.cybertek.day4;

import com.cybertek.utilities.Cyber_Base;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class cyberTraning_with_JsonPath extends Cyber_Base {

/*
Send a GET request to student id 35 as a path parameter
Verify status code/Content Type/Content Encoding = gzip
Verify Date Header exist
Assert that:
firsName Augusta
batch 15
section "N/A"
gender Female
emailAddress cbeech1@sakura.ne.jp"
companyNAme Wordpedia
state "North Carolina"
zipCode 31660

Using jsonPat
 */

    @DisplayName("Get request to /student/:id")
    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id", 35)
                .when()
                .get("/student/{id}");
        //REQUEST PART
        //------------------------------------


//create the JsonPath OBJECT FIRST TO SAVE THE FEATURES IN THE
        //JSONPATH OBJECT,EASIER TO MANAGE YOU KNOW



    }


}
