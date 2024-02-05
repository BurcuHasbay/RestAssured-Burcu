package com.cybertek.utilities;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public abstract class SpartanTEst_Base {


    //We make this class abstract because we can create object from this base class
    @BeforeAll
    public static void init() {
        //Save BASE URL inside this variable so that we don't have to type http method every single time
        RestAssured.baseURI = "http://54.158.33.169:8000";

    }

}