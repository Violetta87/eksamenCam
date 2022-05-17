package com.example.Controllers;

import com.example.Models.Car;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

public class addCarController {
    @GetMapping("/addCars")
    public String addCars(){ return "add-cars";}

    @PostMapping("/addCars")
    public String registrerCars(WebRequest dataFromForm){
        String carModel = dataFromForm.getParameter("carModel");
        String brand = dataFromForm.getParameter("brand");
        String carEmissionCost = dataFromForm.getParameter("carEmissionCost");
        String registrationCost = dataFromForm.getParameter("registrationCost");
        String equipmentLevel = dataFromForm.getParameter("equipmentLevel");
        String isRented = dataFromForm.getParameter("isRented");
        String isDamaged = dataFromForm.getParameter("isDamaged");

        Car newCar = new Car(carModel, brand, carEmissionCost,registrationCost, equipmentLevel, isRented,isDamaged);
        /*kalde service der validerere, som adder til database hvis valideres*/
        return "redirect:/index";
    }

}
