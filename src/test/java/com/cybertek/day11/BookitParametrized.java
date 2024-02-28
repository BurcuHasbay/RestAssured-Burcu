package com.cybertek.day11;

import com.cybertek.utilities.ExcelUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;

public class BookitParametrized {

    public static List<Map<String,String>> getExcelData(){

        /*
        What you do here is to get the information from Excel File and display it in Java
         */
        ExcelUtil bookitFile = new ExcelUtil("src/test/resources/BookItQa3.xlsx","QA3");

        return bookitFile.getDataList();

    }
@ParameterizedTest
    @MethodSource("getExcelData")
    public void bookitTest(Map<String,String> userInfo){

    System.out.println("userInfo.get(\"email\") = " + userInfo.get("email"));
    System.out.println("userInfo.get(\"password\") = " + userInfo.get("password"));


}



}
