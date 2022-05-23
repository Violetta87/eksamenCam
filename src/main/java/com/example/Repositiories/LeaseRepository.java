package com.example.Repositiories;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

public class LeaseRepository {
    private Connection connection = CreateConnectionMySQL.createConnectionToMySQL();

    public void addLeaseToDB(int customerID, int carID, int employeeID, int subscriptionID, int dropoffID, int price, Date dateOfAgreement, Date rentalStartdate, Date rentalEnddate, String licensePlate, boolean isActive) throws SQLException {
        Statement statement = CreateConnectionMySQL.createStatement(connection);
        String mySQLStatement = "INSERT INTO rental_agreement (customer_id, car_id, employee_id, subscription_id, dropoff_id, price, date_of_agreement, rental_startdate, rental_enddate, license_plate, is_active) VALUES (´" + customerID + "´, ´" + carID + "´, ´" + employeeID + "´, ´" + subscriptionID + "´, ´" + dropoffID + "´, ´" + price + "´, ´" + dateOfAgreement + "´, ´" + rentalStartdate + "´, ´" + rentalEnddate + "´, ´" + licensePlate + "´, ´" + isActive +"´)";
        statement.executeUpdate(mySQLStatement);
    }
}
