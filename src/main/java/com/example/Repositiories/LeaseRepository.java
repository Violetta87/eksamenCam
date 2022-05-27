package com.example.Repositiories;

import com.example.Models.Customer;
import com.example.utility.CreateConnectionMySQL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

public class LeaseRepository {
    private Connection connection = CreateConnectionMySQL.createConnectionToMySQL();

    public void addLeaseToDB(Customer customer, int carID, int employeeID, int leaseID, int dropoffID, double price, Date dateOfAgreement, Date rentalStartdate, Date rentalEnddate, boolean isActive) throws SQLException {
        Statement statement = CreateConnectionMySQL.createStatement(connection);
        String mySQLStatement = "INSERT INTO rental_agreement (customer_id, car_id, employee_id, subscription_id, dropoff_id, price, date_of_agreement, rental_startdate, rental_enddate, is_active) VALUES (´" + customer + "´, ´" + carID + "´, ´" + employeeID + "´, ´" + leaseID + "´, ´" + dropoffID + "´, ´" + price + "´, ´" + dateOfAgreement + "´, ´" + rentalStartdate + "´, ´" + rentalEnddate + "´, ´" + isActive +"´)";
        statement.executeUpdate(mySQLStatement);
    }
}
