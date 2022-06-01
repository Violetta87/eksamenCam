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

/*Carl EMil*/

@Controller
public class DamageController {
    private DamageService damageService = new DamageService();
    private RentalAgreementService rentalAgreementService = new RentalAgreementService();



    @GetMapping("/add-damage-report")
    public String damagePage(){
        return "add-damage-report";
    }


}
