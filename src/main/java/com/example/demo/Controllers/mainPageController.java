package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainPageController {
    @GetMapping("/hej")
    public String mainpage(){
        return "mainPage";
    }
}
