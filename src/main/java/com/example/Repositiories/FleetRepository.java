package com.example.Repositiories;

import com.example.Models.Car;
import com.example.utility.CreateConnectionMySQL;

import java.sql.*;
import java.util.ArrayList;

public class FleetRepository implements CRUDInterface <Car> {
    // har slået dette rep sammen med dit AddcarRep :)
    Connection connection = CreateConnectionMySQL.createConnectionToMySQL();
    Statement statement = CreateConnectionMySQL.createStatement(connection);

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

    @Override
    public boolean create(Car entity) {

        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO fleet(model,brand,carbon_emission,registration_cost,equipment_level,is_rented, is_sold,is_damaged, chassis_number, VIN_number) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?) ");

            stmt.setString(1, entity.getCarModel());
            stmt.setString(2, entity.getBrand());
            stmt.setInt(3, entity.getCarbonEmission());
            stmt.setDouble(4, entity.getRegistrationCost());
            stmt.setString(5, entity.getEquipmentLevel());
            stmt.setBoolean(6, entity.getRented());
            stmt.setBoolean(7, entity.getSold());
            stmt.setBoolean(8, entity.getDamaged());
            stmt.setString(9, entity.getChassisNumber());
            stmt.setString(10, entity.getVinNumber());

            stmt.executeUpdate();
            System.out.println("Car has been created");

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("something went wrong");
            return false;

        }

    }

    @Override
    public Car getSingleEntityById(int id) {
        return null;
    }


    @Override
    public ArrayList<Car> getAllEntities() {
        ArrayList<Car> carList = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM fleet");
            ResultSet rs = stmt.executeQuery();


            while(rs.next()){
                String carModel = rs.getString("model");
                String brand = rs.getString("brand");
                int carbonEmission = rs.getInt("carbon_emission");
                int registrationCost = rs.getInt("registration_cost");
                String equipmentLevel = rs.getString("equipment_level");
                boolean isRented = rs.getBoolean("is_rented");
                boolean is_sold = rs.getBoolean("is_sold");
                boolean isDamaged = rs.getBoolean("is_damaged");
                String chassisNumber = rs.getString("chassis_number");
                String vinNumber = rs.getString("VIN_number");


                Car newCar = new Car(carModel,brand,carbonEmission,registrationCost,equipmentLevel,isRented,is_sold,isDamaged,chassisNumber,vinNumber);
                carList.add(newCar);
                System.out.println("All available Cars are found");

            }


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("something went wrong");
        }

        return carList;
    }

    @Override
    public boolean update(Car entity) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

}
