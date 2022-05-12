package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PriceRentedCarsController {

    @GetMapping("/rentedCarList")
    public String rentedCarList(){
        return "rentedCarList";
    }
}
