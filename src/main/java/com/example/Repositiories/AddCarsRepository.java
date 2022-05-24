package com.example.Repositiories;

import com.example.Models.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AddCarsRepository implements CRUDInterface <Car> {





    /*public boolean addCars(Car entity) throws SQLException {


        try {
            Connection conn = CreateConnectionMySQL.createConnectionToMySQL();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO fleet(model,brand,carbon_emission,registration_cost,equipment_level,is_rented, is_sold,is_damaged, chassis_number, VIN_number) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?) ");

            stmt.setString(1, entity.getmodelName());
            stmt.setString(2, entity.getBrand());
            stmt.setInt(3, entity.getCarbonEmission());
            stmt.setInt(4, entity.getRegistrationCost());
            stmt.setString(5, entity.getEquipmentLevel());
            stmt.setBoolean(6, entity.isRented());
            stmt.setBoolean(7, entity.isSold());
            stmt.setBoolean(8, entity.isDamaged());
            stmt.setInt(9, entity.getChassisNumber());
            stmt.setInt(10, entity.getVinNumber());

            stmt.executeUpdate();
            System.out.println("Car has been created");

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("something went wrong");
            return false;

        }
    }*/

    @Override
    public boolean create(Car entity) throws SQLException {

        try {
            Connection conn = CreateConnectionMySQL.createConnectionToMySQL();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO fleet(model,brand,carbon_emission,registration_cost,equipment_level,is_rented, is_sold,is_damaged, chassis_number, VIN_number) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?) ");

            stmt.setString(1, entity.getCarModel());
            stmt.setString(2, entity.getBrand());
            stmt.setInt(3, entity.getCarbonEmission());
            stmt.setInt(4, entity.getRegistrationCost());
            stmt.setString(5, entity.getEquipmentLevel());
            stmt.setBoolean(6, entity.isRented());
            stmt.setBoolean(7, entity.isSold());
            stmt.setBoolean(8, entity.isDamaged());
            stmt.setInt(9, entity.getChassisNumber());
            stmt.setInt(10, entity.getVinNumber());

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
        Connection conn = CreateConnectionMySQL.createConnectionToMySQL();
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT FROM fleet");
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
                    int chassisNumber = rs.getInt("chassis_number");
                    int vinNumber = rs.getInt("VIN_number");


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
    public boolean update(Car enitity) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
