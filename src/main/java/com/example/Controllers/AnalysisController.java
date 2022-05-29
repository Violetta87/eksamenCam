package com.example.Controllers;


import com.example.Models.RentalAgreement;
import com.example.Repositiories.RentalAgreementRepository;
import com.example.Services.RentalAgreementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;

@Controller
public class AnalysisController {
    RentalAgreementService rentalAgreementService = new RentalAgreementService();

    @GetMapping("/statistics")
    public String statisticsPage(Model model) throws SQLException {
        model.addAttribute("CarsCurrentlyRentedOut", rentalAgreementService.getAllCarsCurrentlyRentedOut());
        model.addAttribute("currentEarningsFromRentals", rentalAgreementService.currentRentalIncome());
        return "statistics";
    }

}
