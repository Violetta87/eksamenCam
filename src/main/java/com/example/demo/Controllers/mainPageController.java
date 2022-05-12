package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainPageController {
    @GetMapping("/")
    public String mainpage(){
        return "mainPage";
    }

}


