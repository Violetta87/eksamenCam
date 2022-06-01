package com.example.Repositiories;
/*Camella*/
import com.example.Models.Car;
import com.example.utility.CreateConnectionMySQL;

import java.sql.*;
import java.util.ArrayList;

public class FleetRepository implements CRUDInterface <Car> {

    Connection connection = CreateConnectionMySQL.createConnectionToMySQL();
    Statement statement = CreateConnectionMySQL.createStatement(connection);

    public ArrayList<Car> selectCarsByRentalStatus(boolean carIsRented) throws SQLException {
        // metoden viser enten biler
        String mySQLStatement = "SELECT * FROM fleet WHERE is_rented='" + carIsRented +"'";
        ResultSet resultSet = null;
        resultSet = statement.executeQuery(mySQLStatement);


        ArrayList<Car> rentalCars = new ArrayList<>();


        while (resultSet.next()) {
            Car rentalCar = new Car(resultSet.getString("vin_number"),
                    resultSet.getString("model"),
                    resultSet.getString("brand"),
                    resultSet.getInt("carbon_emission"),
                    resultSet.getDouble("registration_cost"),
                    resultSet.getString("equipment_level"),
                    resultSet.getBoolean("is_rented"),
                    resultSet.getBoolean("is_sold"),
                    resultSet.getBoolean("is_damaged"),
                    resultSet.getString("chassis_number"));
            rentalCars.add(rentalCar);
        }
        return rentalCars;
        }

    @Override
    public boolean create(Car entity) {

        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO fleet(vin_number,model,brand,carbon_emission,registration_cost,equipment_level,is_rented, is_sold,is_damaged, chassis_number) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?) ");

            stmt.setString(1, entity.getVinNumber());
            stmt.setString(2, entity.getCarModel());
            stmt.setString(3, entity.getBrand());
            stmt.setInt(4, entity.getCarbonEmission());
            stmt.setDouble(5, entity.getRegistrationCost());
            stmt.setString(6, entity.getEquipmentLevel());
            stmt.setBoolean(7, entity.getRented());
            stmt.setBoolean(8, entity.getSold());
            stmt.setBoolean(9, entity.getDamaged());
            stmt.setString(10, entity.getChassisNumber());


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
                String vinNumber = rs.getString("VIN_number");
                String carModel = rs.getString("model");
                String brand = rs.getString("brand");
                int carbonEmission = rs.getInt("carbon_emission");
                int registrationCost = rs.getInt("registration_cost");
                String equipmentLevel = rs.getString("equipment_level");
                boolean isRented = rs.getBoolean("is_rented");
                boolean is_sold = rs.getBoolean("is_sold");
                boolean isDamaged = rs.getBoolean("is_damaged");
                String chassisNumber = rs.getString("chassis_number");


                Car newCar = new Car(vinNumber,carModel,brand,carbonEmission,registrationCost,equipmentLevel,isRented,is_sold,isDamaged,chassisNumber);
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
