package com.example.Controllers;

import com.example.Models.Car;
import com.example.Models.Customer;
import com.example.Models.Lease;
import com.example.Services.LeaseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.sql.Date;
import java.sql.SQLException;

@Controller
public class LeaseController {
        private LeaseService leaseService = new LeaseService();

        @GetMapping("/tilfoj-bil")
        public String addLeasePage(){
                return "add-lease";
        }

        @PostMapping("/tilfoj-bil")
        public String addLeaseToDB(Customer customer, int carID, int employeeID, int leaseID, int dropoffID, double price, Date dateOfAgreement, Date rentalStartdate, Date rentalEnddate, boolean isActive) throws SQLException {
                leaseService.createLease(customer, carID, employeeID, leaseID, dropoffID, price, dateOfAgreement, rentalStartdate, rentalEnddate, isActive);
                return "hejSLETMIG"; //HALLO JEG SKAL ALTSÅ IKKE VÆRE HER
        }
}
