package com.example.Controllers;

import com.example.Models.Car;
import com.example.Repositiories.AddCarsRepository;
import com.example.Services.AddCarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class AddCarController {

    private AddCarService addCarService = new AddCarService();

    @GetMapping("/addCar")
    public String addCar(){
        return "add-cars";}

    @PostMapping("/addCar")
    public String create(@ModelAttribute Car car) {
       addCarService.createCar(car);
        return "redirect:/carList";
    }


    @GetMapping("/carList")
    public String carlist(Model model){
        model.addAttribute("carList",addCarService.showCarList());
        return "carList";
    }



    @GetMapping("/availableCars")
    public String availableCars(Model model){
    model.addAttribute("availableCarList",addCarService.showAvailableCars());
        return "available-cars";
    }



}
