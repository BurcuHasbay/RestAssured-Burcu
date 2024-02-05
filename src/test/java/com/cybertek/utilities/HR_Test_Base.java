package com.cybertek.utilities;

import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public class HR_Test_Base {

    @BeforeAll
    public static void init() {


        //Save BASE URL inside this variable so that we don't have to type http method every single time
        baseURI = "http://54.158.33.169:1000/ords/hr";

    }

}


