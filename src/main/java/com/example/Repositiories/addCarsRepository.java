package com.example.Repositiories;

import com.example.Models.Car;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/*public class addCarsRepository {

    public boolean addCars(Car entity) throws SQLException {

        Connection conn = DriverManager.getConnection("sdc-asasd","root","yaaas");
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO car(model,brand,carbonEmission,registrationCost,equipmemtLevel,isRented,isDamaged) "
                "VALUES (?,?,?,?,?,?,?) ");

        stmt.setString(1,entity.getmodelName());
        stmt.setString(2,entity.getBrand());
        stmt.setInt(3,entity.getCarbonEmission());
        stmt.setInt(4, entity.getRegistrationCost());
        stmt.setString(5,entity.getEquipmentLevel());



        return true;
    }
}
*/