package com.example.Controllers;

import com.example.Models.Customer;
import com.example.Models.RentalAgreement;
import com.example.Services.CustomerService;
import com.example.Services.RentalAgreementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.sql.SQLException;

public class RentalAgreementController {
    private CustomerService customerService = new CustomerService();
    private RentalAgreementService rentalAgreementService = new RentalAgreementService();

    @GetMapping("/add-rental-agreement")
    public String GetRentalAgreementPage() {
        return "add-rental-agreement";
    }

    @PostMapping("/add-rental-agreement")
    public String PostRentalAgreementPage(@RequestParam("firstname") String firstname,
                                          @RequestParam("lastname") String lastname,
                                          @RequestParam("address") String address,
                                          @RequestParam("email") String email,
                                          @RequestParam("phoneNumber") String phoneNumber,
                                          @RequestParam("rentalCar") String vinNumber,
                                          @RequestParam("dateOfAgreement") Date dateOfAgreement,
                                          @RequestParam("rentalStartdate") Date rentalStartdate,
                                          @RequestParam("rentalEnddate") Date rentalEnddate,
                                          @RequestParam("licensePlate") String licensePlate,
                                          @RequestParam("employeeID") int employeeID,
                                          @RequestParam("dropOff") String dropOff,
                                          @RequestParam("price") double price) throws SQLException {

        Customer customer = customerService.createCustomerObject(firstname, lastname, address, email, phoneNumber);
        customerService.insertCustomerDB(customer);
        // customer is fetched from DB after being created to get the generated customerID
        customer = customerService.insertAndSelectCustomer(customer);

        RentalAgreement rentalAgreement = rentalAgreementService.createRentalAgreementObject(customer.getCustomerID(), vinNumber, employeeID, dropOff, price, dateOfAgreement, rentalStartdate, rentalEnddate, licensePlate);
        rentalAgreementService.insertRentalAgreementDB(rentalAgreement);

        return "add-rental-agreement";
    }
    @PostMapping("/remove-rental-agreement/{rental_agreement_id}")
    public String removeRentalAgreement(@PathVariable("rental_agreement_id") int rentalAgreementID) throws SQLException {
        RentalAgreement rentalAgreement = rentalAgreementService.selectRentalAgreement(rentalAgreementID);
        rentalAgreementService.insertRentalAgreementInHistoryTable(rentalAgreement);
        rentalAgreementService.deleteRentalAgreement(rentalAgreementID);
        return "add-rental-agreement";
    }

}
