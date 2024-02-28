package com.cybertek.day11;

import com.cybertek.utilities.ExcelUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

public static List<Map<String,String>> getExcelData(){

     //Create Excel file Object
    ExcelUtil vytravkFile = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short");
     //Return excel sheet as a list of Map
    return vytravkFile.getDataList();
}

        @ParameterizedTest
        @MethodSource("getExcelData")
    public void excelParamTest(Map<String,String> userInfo){

            System.out.println("FirstName: " +userInfo.get("firstname"));
            System.out.println("LastName: " +userInfo.get("lastname"));


        }


}
