package com.cybertek.utilities;

import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public abstract class Cyber_Base {
    //We make this class abstract because we can create object from this base class
    @BeforeAll
    public static void init(){
        //Save BASE URL inside this variable so that we don't have to type http method every single time

        baseURI = "https://api.training.cydeo.com/";


    }

}
