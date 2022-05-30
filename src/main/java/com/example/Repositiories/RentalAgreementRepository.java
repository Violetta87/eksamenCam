package com.example.Repositiories;

import com.example.Models.Car;
import com.example.Models.Customer;
import com.example.Models.RentalAgreement;
import com.example.utility.CreateConnectionMySQL;

import java.sql.*;
import java.util.ArrayList;

public class RentalAgreementRepository implements CRUDInterface <RentalAgreement> {
    private Connection connection = CreateConnectionMySQL.createConnectionToMySQL();
    private Statement statement = CreateConnectionMySQL.createStatement(connection);


    public RentalAgreement selectRentalAgreementByCar(String vinNumber) throws SQLException {
        String mySQLStatement = "SELECT * from rental_agreement WHERE vin_number='" + vinNumber +"'";
        RentalAgreement rentalAgreement = null;

        ResultSet resultSet = statement.executeQuery(mySQLStatement);
        while (resultSet.next()) {
            rentalAgreement = new RentalAgreement(resultSet.getInt("customer_id"),
                    resultSet.getString("VIN_number"),
                    resultSet.getInt("employee_id"),
                    resultSet.getString("drop_off"),
                    resultSet.getDouble("price"),
                    resultSet.getDate("date_of_agreement"),
                    resultSet.getDate("rental_startdate"),
                    resultSet.getDate("rental_enddtae"),
                    resultSet.getString("license_plate"));
        }
        return rentalAgreement;
    }

    public void updateRentalStatus(String vinNumber) throws SQLException {
        String mySQLStatement = "UPDATE fleet set is_rented='true' WHERE VIN_number='" + vinNumber + "'";
        statement.executeUpdate(mySQLStatement);

    }

    public void addRentalAgreementToHistory(RentalAgreement rentalAgreement) throws SQLException {
        String mySQLStatement = "INSERT INTO rental_agreement_history (customer_id, VIN_number, employee_id, dropoff, price, date_of_agreement, rental_startdate, rental_enddate, license_plate) VALUES ('" + rentalAgreement.getCustomerID() + "', '" + rentalAgreement.getVinNumber() +  "', '" + rentalAgreement.getEmployeeID() + "', '" + rentalAgreement.getDropOff() + "', '" + rentalAgreement.getPrice() + "', '" + rentalAgreement.getDateOfAgreement() + "', '" + rentalAgreement.getRentalStartdate() + "', '" + rentalAgreement.getRentalEnddate() + "', '" + rentalAgreement.getLicensePlate() + "')";
        statement.executeUpdate(mySQLStatement);
    }

    @Override
    public boolean create(RentalAgreement entity) throws SQLException {
        String mySQLStatement = "INSERT INTO rental_agreement (customer_id, VIN_number, employee_id, dropoff, price, date_of_agreement, rental_startdate, rental_enddate, license_plate) VALUES ('" + entity.getCustomerID() + "', '" + entity.getVinNumber() +  "', '" + entity.getEmployeeID() + "', '" + entity.getDropOff() + "', '" + entity.getPrice() + "', '" + entity.getDateOfAgreement() + "', '" + entity.getRentalStartdate() + "', '" + entity.getRentalEnddate() + "', '" + entity.getLicensePlate() + "')";
        statement.executeUpdate(mySQLStatement);
        return true;
    }

    @Override
    public RentalAgreement getSingleEntityById(int id) throws SQLException {
        String mySQLStatement = "SELECT * FROM rental_agreement WHERE rental_agreement_id='" + id + "'";
        ResultSet resultSet = statement.executeQuery(mySQLStatement);
        RentalAgreement rentalAgreement = null;

        while (resultSet.next()) {
            rentalAgreement = new RentalAgreement(resultSet.getInt("customer_id"),
                    resultSet.getString("VIN_number"),
                    resultSet.getInt("employee_id"),
                    resultSet.getString("drop_off"),
                    resultSet.getDouble("price"),
                    resultSet.getDate("date_of_agreement"),
                    resultSet.getDate("rental_startdate"),
                    resultSet.getDate("rental_enddtae"),
                    resultSet.getString("license_plate"));
        }
        return rentalAgreement;
    }

    @Override
    public ArrayList<RentalAgreement> getAllEntities() throws SQLException {
        String mySQLStatement = "SELECT * from rental_agreement";
        ArrayList<RentalAgreement> rentalAgreements = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery(mySQLStatement);

        while (resultSet.next()) {
            RentalAgreement rentalAgreement = new RentalAgreement(resultSet.getInt("customer_id"),
                    resultSet.getString("VIN_number"),
                    resultSet.getInt("employee_id"),
                    resultSet.getString("drop_off"),
                    resultSet.getDouble("price"),
                    resultSet.getDate("date_of_agreement"),
                    resultSet.getDate("rental_startdate"),
                    resultSet.getDate("rental_enddtae"),
                    resultSet.getString("license_plate"));
                rentalAgreements.add(rentalAgreement);
            }
        return rentalAgreements;
    }

    @Override
    public boolean update(RentalAgreement entity) {
        return false;
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        String mySQLStatement = "DELETE FROM rental_agreement WHERE rental_agreement_ID='" + id + "'";
        statement.executeUpdate(mySQLStatement);
        return false;
    }
}
