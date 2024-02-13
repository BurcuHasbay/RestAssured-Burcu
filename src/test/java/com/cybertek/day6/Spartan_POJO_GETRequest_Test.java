package com.cybertek.day6;

import com.cybertek.Pojos.SearchForSpartan;
import com.cybertek.Pojos.Spartan;
import com.cybertek.utilities.SpartanTEst_Base;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class Spartan_POJO_GETRequest_Test extends SpartanTEst_Base {


@DisplayName("GET one spartan and CONVERT it to SPARTAN OBJECT")
    @Test
    public void oneSpartanPojo(){

/*
First send a GET request to ONE spartan
Save it inside Response Object
Then create convert one spartan Object from spartanClass
*/

    Response response = given().accept(ContentType.JSON).
            and().
            pathParam("id", 15).
            when()
            .get("/api/spartans/{id}")
            .then()
            .statusCode(200).contentType("application/json")
            .extract().response();

    //Deserialize <<>> JSON TO POJO (JAVA CUSTOM CLASS)
    //2 DIFFERENT WAYS FOR THIS
    //1.USING as() METHOD
    Spartan SP15 = response.as(Spartan.class);
    System.out.println(SP15);
    System.out.println("SP15.getId() = " + SP15.getId());
    System.out.println("SP15.getGender() = " + SP15.getGender());

    //2nd Way for deserialization to custom class
    JsonPath jsonPath = response.jsonPath();
    /* converted our json response to POJO class
     which is our custom class that we created for Spartan */
    Spartan s15 = jsonPath.getObject("",Spartan.class);

    System.out.println(s15);
    System.out.println("s15.getName() = " + s15.getName());
    System.out.println("s15.getGender() = " + s15.getGender());
    System.out.println("s15.getPhone() = " + s15.getPhone());


}

    @Test
    public void spartanSearchWithPOJO(){
    /*
    /spartans/search?nameContains=a§gender=Male
    send get request to endpoint above and save first object with
    type Spartan POJO
     */

        JsonPath jsonPath = given().accept(ContentType.JSON).and()
                .queryParams("nameContains", "a",
                        "gender", "Male")
                .when()
                .get("/api/spartans/search")
                .then()
                .statusCode(200)
                .extract().jsonPath();

        //GET THE first Spartan From Content and PUT inside Spartan Object
        Spartan spartan1 = jsonPath.getObject("content[0]", Spartan.class);

        System.out.println(spartan1);
        System.out.println("spartan1.getName() = " + spartan1.getName());
        System.out.println("spartan1.getId() = " + spartan1.getId());
        System.out.println("spartan1.getGender() = " + spartan1.getGender());


    }


    @Test
    public void testSearchClass(){

        Response response = given().accept(ContentType.JSON).and()
                .queryParams("nameContains", "a",
                        "gender", "Male")
                .when()
                .get("/api/spartans/search")
                .then()
                .statusCode(200)
                .extract().response();

        SearchForSpartan searchResult = response.as(SearchForSpartan.class);

        System.out.println(searchResult.getContent().get(0).getName());


    }
    @DisplayName("GET /spartans/search and save as List<Spartan>")
    @Test
    public void test4(){
        List<Spartan> listOfSpartans = given().accept(ContentType.JSON).and()
                .queryParams("nameContains", "a",
                        "gender", "Male")
                .when()
                .get("/api/spartans/search")
                .then()
                .statusCode(200)
                .extract().jsonPath().getList("content", Spartan.class);

        System.out.println(listOfSpartans.get(1));


    }



}
