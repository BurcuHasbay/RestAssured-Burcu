package com.cybertek.day12;

import com.cybertek.utilities.Cyber_Base;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class CyberTek_Spec_Test extends Cyber_Base {


    /*
    All tests in this class will expect "application/json;charset=UTF-8"
    in the request accept(ContentType.JSON)
    all tests in this class, statusCode will be 200
    all tests in this class, response content type in the Headers
    is "application/json;charset=UTF-8"
     */

    /* Repeated parts in both tests: WHY? BECAUSE IT SHOULD BE REUSABLE
    *accept-ContentType.Json
    *Status-Code = 200
    * Response ContentType in Headers = "application/json;charset=UTF-8"
    *
    **/
    @Test
    public void test1(){
/*
        RequestSpecification requestSpecification1 = given()
                .accept(ContentType.JSON)
                .and().log().all();

        ResponseSpecification responseSpecification1 = expect().statusCode(200)
                .and()
                .contentType("application/json;charset=UTF-8")
                        .logDetail(LogDetail.ALL);
*/
        given().
                         spec(requestSpecification1)
                .when()
                        .get("/student/all")
                .then()
                        .spec(responseSpecification1);





    }

       @Test
    public void test2(){

        given()
                .spec(requestSpecification1)
                .pathParam("id",4)
                .when()
                .get("/student/{id}")
                .then()
                .spec(responseSpecification1);





       }



}
