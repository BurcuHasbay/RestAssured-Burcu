package com.cybertek.utilities;

import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;

public abstract class Cyber_Base {
    //We make this class abstract because we can create object from this base class

    public static RequestSpecification requestSpecification1;
    public static ResponseSpecification responseSpecification1;

    @BeforeAll
    public static void init(){
        //Save BASE URL inside this variable so that we don't have to type http method every single time

        baseURI = "https://api.training.cydeo.com/";

        requestSpecification1 = given()
                .accept(ContentType.JSON)
                .and().log().all();

        responseSpecification1 = expect().statusCode(200)
                .and()
                .contentType("application/json;charset=UTF-8")
                .logDetail(LogDetail.ALL);

    }

}
