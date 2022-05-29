package com.example.Repositiories;

import com.example.Models.Car;
import com.example.Models.Customer;
import com.example.Models.RentalAgreement;
import com.example.utility.CreateConnectionMySQL;

import java.sql.*;
import java.util.ArrayList;

public class RentalAgreementRepository {
    private Connection connection = CreateConnectionMySQL.createConnectionToMySQL();
    private Statement statement = CreateConnectionMySQL.createStatement(connection);
    private String succesMessage = "Query to rental_agreement table succes";
    private String errorMessage = "Query to rental_agreement table failed";

    public void addRentalAgreementToDB(Customer customer, int carID, int employeeID, int leaseID, int dropoffID, double price, Date dateOfAgreement, Date rentalStartdate, Date rentalEnddate, boolean isActive) {
        String mySQLStatement = "INSERT INTO rental_agreement (customer_id, car_id, employee_id, subscription_id, dropoff_id, price, date_of_agreement, rental_startdate, rental_enddate, is_active) VALUES (´" + customer + "´, ´" + carID + "´, ´" + employeeID + "´, ´" + leaseID + "´, ´" + dropoffID + "´, ´" + price + "´, ´" + dateOfAgreement + "´, ´" + rentalStartdate + "´, ´" + rentalEnddate + "´, ´" + isActive +"´)";
        try {
            statement.executeUpdate(mySQLStatement);
            System.out.println(succesMessage);
        } catch (SQLException e) {
            System.out.println(errorMessage);
            e.printStackTrace();
        }
    }

    public ArrayList<RentalAgreement> selectAllRentalAgreements() {
        String mySQLStatement = "SELECT * from rental_agreement";
        ArrayList<RentalAgreement> rentalAgreements = new ArrayList<>();

        try {
            ResultSet resultSet = statement.executeQuery(mySQLStatement);
            System.out.println(succesMessage);

            while (resultSet.next()) {
                RentalAgreement rentalAgreement = new RentalAgreement(resultSet.getInt("customer_id"),
                        resultSet.getInt("VIN_number"),
                        resultSet.getInt("employee_id"),
                        resultSet.getString("drop_off"),
                        resultSet.getDouble("price"),
                        resultSet.getDate("date_of_agreement"),
                        resultSet.getDate("rental_startdate"),
                        resultSet.getDate("rental_enddtae"),
                        resultSet.getString("license_plate"));
                rentalAgreements.add(rentalAgreement);
            }

        } catch (SQLException e) {
            System.out.println(errorMessage);
            e.printStackTrace();
        }
       return rentalAgreements;
    }

    public RentalAgreement selectRentalAgreementByCar(String vinNumber) {
        String mySQLStatement = "SELECT * from rental_agreement WHERE vin_number='" + vinNumber +"'";
        RentalAgreement rentalAgreement = null;

        try {
            ResultSet resultSet = statement.executeQuery(mySQLStatement);
            System.out.println(succesMessage);

            while (resultSet.next()) {
                rentalAgreement = new RentalAgreement(resultSet.getInt("customer_id"),
                        resultSet.getInt("VIN_number"),
                        resultSet.getInt("employee_id"),
                        resultSet.getString("drop_off"),
                        resultSet.getDouble("price"),
                        resultSet.getDate("date_of_agreement"),
                        resultSet.getDate("rental_startdate"),
                        resultSet.getDate("rental_enddtae"),
                        resultSet.getString("license_plate"));
            }

        } catch (SQLException e) {
            System.out.println(errorMessage);
            e.printStackTrace();
        }
        return rentalAgreement;
    }

    public void updateRentalStatus(String vinNumber) {
        String mySQLStatement = "UPDATE fleet set is_rented='true' WHERE VIN_number='" + vinNumber + "'";
        try {
            statement.executeUpdate(mySQLStatement);
            System.out.println(succesMessage);
        } catch (SQLException e) {
            System.out.println(errorMessage);
            e.printStackTrace();
        }
    }
}
