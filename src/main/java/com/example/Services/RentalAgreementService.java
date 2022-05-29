package com.example.Services;

import com.example.Models.Car;
import com.example.Models.Customer;
import com.example.Models.RentalAgreement;
import com.example.Repositiories.FleetRepository;
import com.example.Repositiories.RentalAgreementRepository;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class RentalAgreementService {
    private RentalAgreementRepository rentalAgreementRepository = new RentalAgreementRepository();
    private FleetRepository fleetRepository = new FleetRepository();

    public void createLease(Customer customer, int carID, int employeeID, int leaseID, int dropoffID, double price, Date dateOfAgreement, Date rentalStartdate, Date rentalEnddate, boolean isActive) throws SQLException {
        rentalAgreementRepository.addRentalAgreementToDB(customer, carID, employeeID, leaseID, dropoffID, price, dateOfAgreement, rentalStartdate, rentalEnddate, isActive);
    }

    public RentalAgreement getRentalAgreementByVinNumber(String vinNumber) {
       return rentalAgreementRepository.selectRentalAgreementByCar(vinNumber);
    }

    public double currentRentalIncome() throws SQLException {
        ArrayList<RentalAgreement> activeRentalAgreements = rentalAgreementRepository.selectAllRentalAgreements();
        double accumulatedPrice = 0;

        for (int i = 0; i < activeRentalAgreements.size(); i++) {
            accumulatedPrice += activeRentalAgreements.get(i).getPrice();
        }
        return accumulatedPrice;
    }

    public ArrayList<Car> getAllCarsCurrentlyRentedOut() throws SQLException {
        return fleetRepository.selectCarsByRentalStatus(true);
    }

}
