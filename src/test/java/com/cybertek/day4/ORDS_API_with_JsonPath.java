package com.cybertek.day4;

import com.cybertek.utilities.HR_Test_Base;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
public class ORDS_API_with_JsonPath extends HR_Test_Base {
    @DisplayName("GET request to Countries using Json Path")
    @Test
    public void test1(){

            //NEITHER QUERY PARAMS NOR PATH PARAMS
        //ONLY THE SHORTEST WAY TO GET ALL THE COUNTRIES
        Response response = get("/countries");


        //TO USE JSON PATH
        //GET THE SECOND COUNTRY NAME WITH JSONPATH

        //FIRST CREATE JsonPath OBJECT
        JsonPath jsonPath = response.jsonPath();

        String secondCountryId = jsonPath.getString("items[1].country_name");
        System.out.println("secondCountryId = " + secondCountryId);

        //GET ALL THE country ids
        List<String> allCountriesId = jsonPath.getList("items.country_id");
        System.out.println("allCountriesId = " + allCountriesId);

        //GET ALL THE COUNTRY NAMES WITH REGION IDs THAT IS EQUAL TO 2
        //One SHot way
        List<String> countryNameWithRegionId2 = jsonPath.getList("items.findAll{it.region_id==2}.country_name");
        System.out.println("countryNameWithRegionId2 = " + countryNameWithRegionId2);

    }


        @DisplayName("GET request to /employees with query param")
        @Test
        public void test2(){

            Response response = given().queryParam("limit", 107).when().get("/employees");


            //GET ME ALL THE EMAILS OF THE EMPLOYEES WHO ARE CURRENTLY WORKING AS
            //IT_PROG

            //create the JsonPath OBJECT FIRST TO SAVE THE FEATURES IN THE
            //JSONPATH OBJECT,EASIER TO MANAGE YOU KNOW

            JsonPath jsonPath = response.jsonPath();

            List<Object> employeeITPROGs = jsonPath.getList("items.findAll{it.job_id==\"IT_PROG\"}.email");
            System.out.println("employeeITPROGs = " + employeeITPROGs);

            //GET ME THE FIRST NAME OF THE EMPLOYEES WHO MAKE MORE THAN 10000
            List<Object> firstNameMore10000 = jsonPath.getList("items.findAll{it.salary>=10000}.first_name");

            System.out.println("firstNameMore10000 = " + firstNameMore10000);


        }


















}
