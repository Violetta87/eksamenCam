package com.example.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

public class RentalAgreementController {

    @GetMapping("/add-rental-agreement")
    public String GetRentalAgreementPage() {
        return "add-rental-agreement";
    }

    @PostMapping("/add-rental-agreement")
    public String PostRentalAgreementPage(@RequestParam("firstname") String firstname,
                                          @RequestParam("lastname") String lastname,
                                          @RequestParam("address") String address,
                                          @RequestParam("email") String email,
                                          @RequestParam("phonenumber") int phonenumber,
                                          @RequestParam("rentalCar") String vinNumber,
                                          @RequestParam("dateOfAgreement") Date dateOfAgreement,
                                          @RequestParam("rentalStartdate") Date rentalStart,
                                          @RequestParam("rentalEnddate") Date rentalEnddate,
                                          @RequestParam("licensePlate") String licensePlate) {
        // WIP
    }

}
