package com.cybertek.day10;

import org.junit.jupiter.api.BeforeAll;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class Formula1_xmlTEst {

    @BeforeAll
    public static void setUp(){


        baseURI ="http://ergast.com";
    }

}
