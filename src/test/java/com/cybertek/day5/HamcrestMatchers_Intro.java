package com.cybertek.day5;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
public class HamcrestMatchers_Intro {

@Test
    public void simpleTest1(){

    //look for the equality
    assertThat(5+5, is(10));

    assertThat(5+5,equalTo(10));

    assertThat(5+5,is(equalTo(10)));





}

}
