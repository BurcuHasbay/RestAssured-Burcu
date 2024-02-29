package com.cybertek.day12;
import com.cybertek.utilities.Cyber_Base;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class oldRestAssuredTests extends Cyber_Base {

    @Test
    public void getAllStudents(){

        given().accept(ContentType.JSON)
                .get("/student/all")
                .then()
                .statusCode(200)
                .contentType("application/json;charset=UTF-8")
                .body("students.studentId[0]",is(4))
                .log().all();
    }

    @DisplayName("New way")
    @Test
    public void getAllStudents2(){

        given().accept(ContentType.JSON)
                .and()
                .expect()
                .statusCode(200)
                .contentType("application/json;charset=UTF-8")
                .body("students.studentId[0]",is(4))
                .when()
                .get("/student/all");

    }

}
