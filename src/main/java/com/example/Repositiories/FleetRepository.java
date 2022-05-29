package com.example.Repositiories;

import com.example.Models.Car;
import com.example.utility.CreateConnectionMySQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FleetRepository {
    Connection connection = CreateConnectionMySQL.createConnectionToMySQL();
    Statement statement = CreateConnectionMySQL.createStatement(connection);
    String messageSucces = "query to fleet table succes";
    String messageError = "query to fleet table failed";

    public ArrayList<Car> selectCarsByRentalStatus(boolean carIsRented) throws SQLException {
        // metoden viser enten biler, som er lejet ud eller som er ledige alt efter metode parameter
        String mySQLStatement = "SELECT * FROM fleet WHERE is_rented='" + carIsRented +"'";
        ResultSet resultSet = null;
            resultSet = statement.executeQuery(mySQLStatement);


        ArrayList<Car> rentalCars = new ArrayList<>();

        while (resultSet.next()) {
            Car rentalCar = new Car(resultSet.getString("model"),
                    resultSet.getString("brand"),
                    resultSet.getInt("carbon_emission"),
                    resultSet.getInt("registration_cost"),
                    resultSet.getString("equipment_level"),
                    resultSet.getBoolean("is_rented"),
                    resultSet.getBoolean("is_sold"),
                    resultSet.getBoolean("is_damaged"),
                    resultSet.getString("chassis_number"),
                    resultSet.getString("VIN_number"));
            rentalCars.add(rentalCar);
        }
        return rentalCars;
        }
}
