package com.example.Controllers;


import com.example.Models.RentalAgreement;
import com.example.Repositiories.RentalAgreementRepository;
import com.example.Services.AddCarService;
import com.example.Services.RentalAgreementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.sql.Date;
import java.sql.SQLException;

@Controller
public class RentalAgreementController {
    private RentalAgreementRepository rentalAgreementRepository = new RentalAgreementRepository();
    private RentalAgreementService rentalAgreementService = new RentalAgreementService();
    private AddCarService addCarService = new AddCarService();

    @GetMapping("/add-rental-agreement")
    public String GetRentalAgreementPage(Model model) {
        model.addAttribute("availableCars",addCarService.showAvailableCars());
        return "add-rental-agreement";
    }

    @PostMapping("/add-rental-agreement-model")
    public String addRentalAgreement(WebRequest dataFromForm) {
        String vinNumber = dataFromForm.getParameter("rentalCar");
        int customerID= Integer.parseInt(dataFromForm.getParameter("customerID"));
        int employeeID = Integer.parseInt(dataFromForm.getParameter("employeeID"));
        String dateOfAgreement = dataFromForm.getParameter("dateOfAgreement");
        String rentalStartDate = dataFromForm.getParameter("rentalStartDate");
        String rentalEndDate = dataFromForm.getParameter("rentalEndDate");
        String dropOff = dataFromForm.getParameter("dropOff");
        double price = Double.dataFromForm.getParameter("price");
        String licensePlate =dataFromForm.getParameter("licensePlate");

        RentalAgreement rentalAgreement= new RentalAgreement(customerID,vinNumber,employeeID,dateOfAgreement,rentalStartDate,rentalEndDate,dropOff,price,licensePlate);



        return "redirect:/dataregistrering-add";

    }


/*

    @PostMapping("/add-rental-agreement")
    public String PostRentalAgreementPage(@RequestParam("rentalCar") String vinNumber,
                                          @RequestParam("dateOfAgreement") Date dateOfAgreement,
                                          @RequestParam("rentalStartdate") Date rentalStartdate,
                                          @RequestParam("rentalEnddate") Date rentalEnddate,
                                          @RequestParam("licensePlate") String licensePlate,
                                          @RequestParam("employeeID") int employeeID,
                                          @RequestParam("dropOff") String dropOff,
                                          @RequestParam("price") double price) throws SQLException {

        RentalAgreement rentalAgreement = rentalAgreementService.insertRentalAgreementDB(vinNumber, dateOfAgreement, rentalStartdate, rentalEnddate, licensePlate,employeeID,dropOff,price);
        rentalAgreementService.insertRentalAgreementDB(rentalAgreement);

        return "add-rental-agreement";


    }
*/

}
