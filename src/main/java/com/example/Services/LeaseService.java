package com.example.Services;

import com.example.Models.Customer;
import com.example.Repositiories.LeaseRepository;

import java.sql.Date;
import java.sql.SQLException;

public class LeaseService {
    private LeaseRepository leaseRepository = new LeaseRepository();

    public void createLease(Customer customer, int carID, int employeeID, int leaseID, int dropoffID, double price, Date dateOfAgreement, Date rentalStartdate, Date rentalEnddate, boolean isActive) throws SQLException {
        leaseRepository.addLeaseToDB(customer, carID, employeeID, leaseID, dropoffID, price, dateOfAgreement, rentalStartdate, rentalEnddate, isActive);
    }
}
