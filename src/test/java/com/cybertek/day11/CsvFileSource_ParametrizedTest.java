package com.cybertek.day11;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CsvFileSource_ParametrizedTest {

@ParameterizedTest
    @CsvFileSource(resources = "/ZipCode.csv",numLinesToSkip = 1)
    public void zipCodeTest_withFile(String stateArg, String cityArg, int zipCode){

    System.out.println("stateArg = " + stateArg);
    System.out.println("cityArg = " + cityArg);
    System.out.println("zipCode = " + zipCode);

}




}
