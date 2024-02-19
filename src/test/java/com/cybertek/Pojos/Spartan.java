package com.cybertek.Pojos;




/*
{
   "id": 15
   "name": "Meta",
   "gender": "Female"
   "phone": 1938695106
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@JsonIgnoreProperties(value = "id",allowSetters = true)
public class Spartan {

    private String name;

    private String gender;

    private long phone;
    private int id;

}
