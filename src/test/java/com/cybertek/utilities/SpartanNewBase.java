package com.cybertek.utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;


public class SpartanNewBase {

    @BeforeAll
    public static void init(){
       baseURI = "http://54.158.33.169";
       port =7000;
       basePath="/api";
    }

    @AfterAll
    public static void close(){

        //Reset the info we set above, method comes from restAssured library
        // reset();

        //if you are dealing with more than apiS and you need to have
    }

}
