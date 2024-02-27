package com.cybertek.day11;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

public class MethodSource_ParametrizedTest {

    //Imagine that the only source you've got is your method below
 @ParameterizedTest
 @MethodSource("getNames")
 public void testPrintNames(String name){

     System.out.println("name = " + name);
 }

public static List<String> getNames(){

     /*
    YOU CAN GET VALUE FROM ANYWHERE AND ALMOST ANY TYPE.
    RETURN TO YOUR
    DB
    EXCEL
    OTHER APIs
    */
    List<String> nameList = Arrays.asList("Burcu","Osman","Jiye","Ayşegül","Mehtap","Hürrem","Kont","Mansur");
    return nameList;

}

}
