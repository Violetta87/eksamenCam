package com.example.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*Camella */
@Controller
public class IndexController {

    @GetMapping("/login")
    public String login(){
        return "index";
    }

    @PostMapping("/login")
    public String loginData(@RequestParam String username, @RequestParam String password){
        System.out.println(username + password);
        return "redirect:/carList";
    }


    @GetMapping("/dataregistrering-add")
    public String dataregistreringsmenu(){
        return "add";
    }

    @GetMapping("/logout")
    public String logout(){
        return"index";

    }
}
