package com.cybertek.day10;

import com.cybertek.utilities.Spartan_AuthTESTBase;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class Spartan_with_XML extends Spartan_AuthTESTBase {

     @DisplayName("GET request to /api/spartans and verify XML")
    @Test
    public void getSpartanXML(){

         /*
         We will ask for .xml response
         Assert that statusCode is 200
         Assert content Type is xml (we get xml response)
         Verify first spartan name is Meade
          */

         given()
                 .accept(ContentType.XML)
                 .and()
                 .auth().basic("admin","admin")
                 .when()
                 .get("/api/spartans")
                 .then()
                 .statusCode(200)
                 .contentType("application/xml;charset=UTF-8") //verify we got xml through header
                 .body("List.item[0].name",is("Meade"))
                 .body("List.item[0].gender",is("Male"))
                 .log().all();

     }

     @DisplayName("GET request to /api/spartans with xmlPath")
    @Test
    public void testXmlPath(){
         Response response = given()
                 .accept(ContentType.XML)
                 .and()
                 .auth().basic("admin", "admin")
                 .when()
                 .get("/api/spartans");

         //get response xml body/payload and SAve inside the xmlPath Object
         XmlPath xmlPath = response.xmlPath();

         String name = xmlPath.getString("List.item[0].name");
         System.out.println("name = " + name);

         int id = xmlPath.getInt("List.item[2].id");

         System.out.println("id = " + id);

         //HOW TO GET ALL NAMES AND SAVE INSIDE LIST OF STRING
         List<String> listNames = xmlPath.getList("List.items.name");
         System.out.println(listNames);

     }




}
