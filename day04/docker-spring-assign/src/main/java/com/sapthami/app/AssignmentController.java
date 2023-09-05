package com.sapthami.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssignmentController {


    @GetMapping("/name")
    public String name(){
        return "sapthami";
    }
    @GetMapping("/age")
    public int age(){
        return 13;
    }
    @GetMapping("/address")
    public String address(){
        return "Bangalore";
    }

}
