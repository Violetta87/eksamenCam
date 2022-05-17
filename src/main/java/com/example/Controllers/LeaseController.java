package com.example.Controllers;

import com.example.Models.Car;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class LeaseController {

        @GetMapping("/addLeasePage")
        public String addLeasePage(){
                return "add-lease";
        }

}
