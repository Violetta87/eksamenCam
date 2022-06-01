package com.example.Controllers;


import com.example.Models.RentalAgreement;
import com.example.Repositiories.RentalAgreementRepository;
import com.example.Services.AddCarService;
import com.example.Services.RentalAgreementService;
import com.example.Services.WebRequestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;

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
    public String addRentalAgreement(WebRequest dataFromForm) throws SQLException, ParseException {
        WebRequestService wb = new WebRequestService();
        wb.uploadRentalAgreement(dataFromForm);


        return "redirect:/dataregistrering-add";
    }


}
