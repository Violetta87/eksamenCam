package com.example.Repositiories;

import com.example.Models.DamageReport;
import com.example.utility.CreateConnectionMySQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DamageRepository {
    // VIGTIGT! chassis_number og VIN_number skal laves om til en string i MySQL DB.
    private Connection connection = CreateConnectionMySQL.createConnectionToMySQL();
    private Statement statement = CreateConnectionMySQL.createStatement(connection);


    public int selectRentalAgreementID(String numberVIN, String chassisNumber) throws SQLException {
        int carID = selectCarID(numberVIN, chassisNumber);
        String mySQLStatement = "SELECT rental_agreement_id from rental_agreement WHERE car_id='" + carID + "' AND is_active='y'";
        ResultSet resultSet = CreateConnectionMySQL.createQuery(mySQLStatement, statement);
        int rentalAgreementID = 0;

        while (resultSet.next()) {
            rentalAgreementID = resultSet.getInt("rental_agreement_id");
        }
        return rentalAgreementID;
    }

    public int selectCarID(String numberVIN, String chassisNumber) throws SQLException {
        String mySQLStatement = "SELECT car_id FROM fleet WHERE VIN_number='" + numberVIN + "' AND chassis_number='" + chassisNumber + "'";
        ResultSet resultSet = CreateConnectionMySQL.createQuery(mySQLStatement, statement);
        int carID = 0;

        while (resultSet.next()) {
            carID = resultSet.getInt("car_id");
        }
        return carID;
    }

    public void insertDamageReport(DamageReport damageReport) throws SQLException {
        String mySQLStatement = "INSERT INTO damage_report (rental_agreement_id, employee_id, kilometers_exceeded, damage_cost, date) VALUES ('" + damageReport.getRentalAgreementID() + "', '" + damageReport.getEmployeeID() + "', '" + damageReport.getKilometersExceeded() + "', " + damageReport.getDamage_cost() + "', '" + damageReport.getDate() + "')";
        statement.executeUpdate(mySQLStatement);
    }

    public int selectDamageCost(int damageID) throws SQLException {
        String mySQLStatement = "SELECT price FROM damage_matrix WHERE damage_id='" + damageID + "'";
        ResultSet resultSet = CreateConnectionMySQL.createQuery(mySQLStatement, statement);
        int damageCost = 0;

        while (resultSet.next()) {
            damageCost = resultSet.getInt("price");
        }
        return damageCost;
    }



}
