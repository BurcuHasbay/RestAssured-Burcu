package com.cybertek.day11;
import com.cybertek.utilities.ExcelUtil;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class ExcelUtil_Practice {

    @Test
   public void test1(){

       ExcelUtil vytrackFile = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx","QA3-short");

        //method for returning list Of Map
       List<Map<String, String>> dataList = vytrackFile.getDataList();
       for (Map<String, String> rowMap : dataList) {
           System.out.println("rowMap = " + rowMap);
       }


   }


}
