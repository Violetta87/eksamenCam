package com.example.Controllers;

import com.example.Models.DamageReport;
import com.example.Models.RentalAgreement;
import com.example.Services.DamageService;
import com.example.Services.RentalAgreementService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.SQLException;

@Controller
public class DamageController {
    private DamageService damageService = new DamageService();
    private RentalAgreementService rentalAgreementService = new RentalAgreementService();



    @GetMapping("/add-damage-report")
    public String damagePage(){
        return "add-damage-report";
    }

    @PostMapping
    public String getDamageReport(@RequestParam("employee_id") int employeeID, @RequestParam("damageCost") double damageCost, @RequestParam("numberVIN") String vinNumber, @RequestParam("chassisNumber") String chassisNumber, @RequestParam("damageReport") String damageReport, @RequestParam("kilometersExceeded") int kilometersExceeded, @RequestParam("date") Date date, HttpSession session) throws SQLException {
        RentalAgreement rentalAgreement = rentalAgreementService.getRentalAgreementByVinNumber(vinNumber);
        DamageReport damageReportObject = damageService.createDamageReportObject(employeeID, rentalAgreement.getRentalAgreementID(), kilometersExceeded, damageCost, damageReport, date);
        damageService.insertDamageReportDB(damageReportObject);

        return "add-damage-report";
    }

}
