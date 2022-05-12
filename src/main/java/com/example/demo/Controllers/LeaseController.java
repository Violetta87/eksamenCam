package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
 @Controller
public class LeaseController {

        @GetMapping("/addLeasePage")
        public String addLeasePage(){
                return "addLeasePage";
        }
}
