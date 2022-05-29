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





    public void insertDamageReport(DamageReport damageReport) throws SQLException {
        String mySQLStatement = "INSERT INTO damage_report (rental_agreement_id, employee_id, kilometers_exceeded, damage_cost, date) VALUES ('" + damageReport.getRentalAgreementID() + "', '" + damageReport.getEmployeeID() + "', '" + damageReport.getKilometersExceeded() + "', " + damageReport.getDamageCost() + "', '" + damageReport.getDate() + "')";
        statement.executeUpdate(mySQLStatement);
    }}

