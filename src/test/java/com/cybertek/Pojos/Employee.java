package com.cybertek.Pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class Employee {



    @JsonProperty("first_name")
    private String firstNAme;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("job_id")
    private String jobId;

    @JsonProperty("salary")
    private int salary;

}
