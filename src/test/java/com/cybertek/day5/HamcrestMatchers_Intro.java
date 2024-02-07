package com.cybertek.day5;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
public class HamcrestMatchers_Intro {

    @DisplayName("Assertion with Numbers")
@Test
    public void simpleTest1(){

    //look for the equality
    assertThat(5+5, is(10));

    assertThat(5+5,equalTo(10));

    assertThat(5+5,is(equalTo(10)));

    //HOW IS THE NEGATIVE VERSION OF IT?
    assertThat(5+5,is(not(equalTo(9))));
    //OR
    assertThat(5+5,not(equalTo(9)));

    //Number comparison
    //greaterThan
    //greaterThanOrEqualTo
    //lessThan
    //lessThanOrEqualTo

    assertThat(5+5,is(greaterThan(9)));

}

    @DisplayName("Assertion with String")
    @Test
    public void stringHamcrest(){

        //Checking for equality is same as numbers

        String text = "B22 is learning Hamcrest";

        assertThat(text,is("B22 is learning Hamcrest"));

        assertThat(text,equalTo("B22 is learning Hamcrest"));

        assertThat(text,is(equalTo("B22 is learning Hamcrest")));


        //CHECK IF THIS TEXT STARTS WITH B22
        assertThat(text,startsWith("B22"));

        //Now do it in a case-insensitive manner
        assertThat(text,startsWithIgnoringCase("b22"));

        //Check if it ends with .... or not
        assertThat(text,endsWith("Hamcrest"));

        //Check a word in the middle of the text
        assertThat(text,containsString("learning"));
        //with ignoring case sensitivity
        assertThat(text,containsStringIgnoringCase("LEARNING"));

        String str = "  ";

        //TO CHECK if trimmed string is empty string
        //TRIM IT THEN CHECK IF IT IS EMPTY
        assertThat(str.trim(),emptyString());

        //Check if str above is blank
        assertThat(str,blankString());


    }

}
