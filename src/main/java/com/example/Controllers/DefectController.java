package com.example.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class DefectController {
    @GetMapping("/add-damages")
    public String damagePage(){
        return "add-defects";
    }

    @PostMapping
    public String getDamageReport(@PathVariable("employeeID") int employeeID, @RequestParam("numberVIN") String numberVIN, @RequestParam("chassisNumber") String chassisNumber, @RequestParam("defects") String defects, @RequestParam("kilometersExceeded") int kilometersExceeded, HttpSession session) {
        return "add-defects";
    }

}
