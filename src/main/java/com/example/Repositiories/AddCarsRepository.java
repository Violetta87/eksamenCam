package com.example.Repositiories;

import com.example.Models.Car;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AddCarsRepository {





    public boolean addCars(Car entity) throws SQLException {


        try{
            Connection conn = CreateConnectionMySQL.createConnectionToMySQL();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO car(model,brand,carbonEmission,registrationCost,equipmemtLevel,isRented, isSold,isDamaged) " +
                "VALUES (?,?,?,?,?,?,?,?) ");

            stmt.setString(1,entity.getmodelName());
            stmt.setString(2,entity.getBrand());
            stmt.setInt(3,entity.getCarbonEmission());
            stmt.setInt(4, entity.getRegistrationCost());
            stmt.setString(5,entity.getEquipmentLevel());
            stmt.setBoolean(6,entity.isRented());
            stmt.setBoolean(7,entity.isSold());
            stmt.setBoolean(8,entity.isDamaged());

            stmt.executeUpdate();
            System.out.println("Car has been created");

                return true;
    }catch(SQLException e){
            System.out.println("something went wrong");
            return false;

        }

        }
}
