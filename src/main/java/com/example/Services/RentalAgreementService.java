package com.example.Services;

import com.example.Models.Car;
import com.example.Models.Customer;
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



    public RentalAgreement createRentalAgreementObject(int customerID, String vinNumber, int employee_id, String dropOff, double price, Date dateOfAgreement, Date rentalStartdate, Date rentalEnddate, String licensePlate) {
        return new RentalAgreement(customerID, vinNumber, employee_id, dropOff, price, dateOfAgreement, rentalStartdate, rentalEnddate, licensePlate);
    }

    public RentalAgreement selectRentalAgreement(int id) throws SQLException {
        return rentalAgreementRepository.getSingleEntityById(id);
    }

    public void deleteRentalAgreement(int id) throws SQLException {
        rentalAgreementRepository.deleteById(id);
    }

    public void insertRentalAgreementInHistoryTable(RentalAgreement rentalAgreement) throws SQLException {
        rentalAgreementRepository.addRentalAgreementToHistory(rentalAgreement);
    }

    public void insertRentalAgreementDB(RentalAgreement rentalAgreement) throws SQLException {
        rentalAgreementRepository.create(rentalAgreement);
    }

    public RentalAgreement selectRentalAgreementByVinNumberDB(String vinNumber) throws SQLException {
       return rentalAgreementRepository.selectRentalAgreementByCar(vinNumber);
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
