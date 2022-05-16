package com.example.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LeaseController {

        @GetMapping("/addLeasePage")
        public String addLeasePage(){
                return "add-lease";
        }

        @GetMapping("/addCars")
        public String addCars(){ return "add-cars";}

         /*@PostMapping("/addCars")
         public String registrerCars(WebRequest dataFromForm){
                String model = dataFromForm.getParameter("model");
                String brand = dataFromForm.getParameter("brand");
                String carEmissionCost = dataFromForm.getParameter("carEmissionCost");
                String registrationCost = dataFromForm.getParameter("registrationCost");
                String equipmentLevel = dataFromForm.getParameter("equipmentLevel");
                String isRented = dataFromForm.getParameter("isRented");
                String isDamaged = dataFromForm.getParameter("isDamaged");

             Car newCar = new Car(model, brand, carEmissionCost,registrationCost, equipmentLevel, isRented,isDamaged);

         }*/

}
