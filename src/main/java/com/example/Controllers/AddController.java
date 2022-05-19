package com.example.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddController {

    @GetMapping("/add")
    public String addPage(){
        return "add";
    }

}


