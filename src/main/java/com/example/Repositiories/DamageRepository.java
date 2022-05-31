package com.example.Repositiories;

import com.example.Models.DamageReport;
import com.example.utility.CreateConnectionMySQL;

import javax.swing.text.html.parser.Entity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DamageRepository implements CRUDInterface <DamageReport> {

    private Connection connection = CreateConnectionMySQL.createConnectionToMySQL();
    private Statement statement = CreateConnectionMySQL.createStatement(connection);

    @Override
    public boolean create(DamageReport damageReport) throws SQLException {
        String mySQLStatement = "INSERT INTO damage_report (rental_agreement_id, employee_id, kilometers_exceeded, damage_cost, date) VALUES ('" + damageReport.getRentalAgreementID() + "', '" + damageReport.getEmployeeID() + "', '" + damageReport.getKilometersExceeded() + "', " + damageReport.getDamageCost() + "', '" + damageReport.getDate() + "')";
        statement.executeUpdate(mySQLStatement);

        return true;
    }

    @Override
    public DamageReport getSingleEntityById(int id) throws SQLException {
        String mySQLStatement = "SELECT * FROM damage_report WHERE damage_report_id='" + id + "'";
        ResultSet resultSet = statement.executeQuery(mySQLStatement);
        DamageReport damageReport = null;

        while (resultSet.next()) {
            damageReport = new DamageReport(resultSet.getInt("employee_id"),
                    resultSet.getInt("rental_agreement_id"),
                    resultSet.getInt("kilometers_exceeded"),
                    resultSet.getDouble("damage_cost"),
                    resultSet.getString("damage_report"),
                    resultSet.getDate("date"));
        }
        return damageReport;
    }

    @Override
    public ArrayList getAllEntities() throws SQLException {
        String mySQLStatement = "SELECT * FROM damage_report";
        ResultSet resultSet = statement.executeQuery(mySQLStatement);
        ArrayList<DamageReport> damageReports = new ArrayList<>();

        while (resultSet.next()) {
           DamageReport damageReport = new DamageReport(resultSet.getInt("employee_id"),
                    resultSet.getInt("rental_agreement_id"),
                    resultSet.getInt("kilometers_exceeded"),
                    resultSet.getDouble("damage_cost"),
                    resultSet.getString("damage_report"),
                    resultSet.getDate("date"));
           damageReports.add(damageReport);
        }
        return damageReports;
    }

    @Override
    public boolean update(DamageReport entity) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}

