package com.example.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DamageController {
    @GetMapping("/adddamages")
    public String damagepage(){
        return "add-defects";
    }

}
