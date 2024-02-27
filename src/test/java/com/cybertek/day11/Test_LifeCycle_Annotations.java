package com.cybertek.day11;

import groovy.xml.StreamingDOMBuilder;
import org.junit.jupiter.api.*;

public class Test_LifeCycle_Annotations {

//before both of them, if I want to run something in JUnit that would be beforeClass
    @BeforeAll //needs to be static method
    public static void init(){

        System.out.println("Before all is running");
    }

    @BeforeEach //doesn't have to be static
    public void initEach(){
        System.out.println("Before each is running");

    }

    @AfterEach //doesn't have to be static. To close the browser
    public void closerEach(){
        System.out.println("After each is running");

    }



    @Test
    public void test1(){

        System.out.println("Test 1 is running");

    }


    @Disabled
    @Test
    public void test2(){

        System.out.println("Test 2 is running");



    }

    @AfterAll //needs to be static
    public static void closer (){
        System.out.println("After all is running");

    }

}
