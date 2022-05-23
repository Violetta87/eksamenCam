package com.example.Services;

import com.example.Repositiories.LeaseRepository;

import java.sql.Date;
import java.sql.SQLException;

public class LeaseService {
    private LeaseRepository leaseRepository = new LeaseRepository();

    public void createLease(int customerID, int carID, int employeeID, int subscriptionID, int dropoffID, int price, Date dateOfAgreement, Date rentalStartdate, Date rentalEnddate, String licensePlate, boolean isActive) throws SQLException {
        leaseRepository.addLeaseToDB(customerID, carID, employeeID, subscriptionID, dropoffID, price, dateOfAgreement, rentalStartdate, rentalEnddate, licensePlate, isActive);
    }
}
