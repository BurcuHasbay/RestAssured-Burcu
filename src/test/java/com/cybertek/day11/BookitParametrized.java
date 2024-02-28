package com.cybertek.day11;

import com.cybertek.utilities.ExcelUtil;
import io.restassured.http.ContentType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

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

    given().accept(ContentType.JSON)
            .and().baseUri("https://cybertek-reservation-api-qa3.herokuapp.com")
            .queryParams(userInfo)
            .get("/sign")
            .then()
            .statusCode(200)
            .log().body();



}



}
