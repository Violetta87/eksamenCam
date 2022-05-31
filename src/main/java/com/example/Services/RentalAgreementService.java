package com.example.Services;

import com.example.Models.Car;
import com.example.Models.RentalAgreement;
import com.example.Repositiories.CRUDInterface;
import com.example.Repositiories.FleetRepository;
import com.example.Repositiories.RentalAgreementRepository;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class RentalAgreementService {
    private RentalAgreementRepository rentalAgreementRepository = new RentalAgreementRepository();
    private FleetRepository fleetRepository = new FleetRepository();


    public void insertRentalAgreementDB(RentalAgreement rentalAgreement) {
        try {
            rentalAgreementRepository.create(rentalAgreement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public double currentRentalIncome() throws SQLException {
        ArrayList<RentalAgreement> activeRentalAgreements = rentalAgreementRepository.getAllEntities();
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
