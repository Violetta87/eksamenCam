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
        rentalAgreementRepository.create(rentalAgreement);
    }


    public ArrayList<Car> getAllCarsRentedOut() throws SQLException {
        return fleetRepository.selectCarsByRentalStatus(true);
    }


}
