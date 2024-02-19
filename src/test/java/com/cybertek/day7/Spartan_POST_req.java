package com.cybertek.day7;

import com.cybertek.utilities.SpartanTEst_Base;

public class Spartan_POST_req extends SpartanTEst_Base {

    /*
    Given accept type and Content Type is Json
    And request json body is:
   {
    "gender" :"Male",
    "name":"Severus",
    "phone": 8877445594
    }


    When user sends POST request to /api/spartans
    Then StatusCode 201
    And Content type should be application/json
    And Json payload/Response Body should contain:
    "A spartan is Born!" message
    and same data what is posted gender : male ....
     */



}
