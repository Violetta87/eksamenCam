package com.example.Repositiories;

;
import com.example.Models.RentalAgreement;
import com.example.utility.CreateConnectionMySQL;


import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class RentalAgreementRepository implements CRUDInterface <RentalAgreement> {
    private Connection connection = CreateConnectionMySQL.createConnectionToMySQL();
    private Statement statement = CreateConnectionMySQL.createStatement(connection);


    @Override
    public boolean create(RentalAgreement entity) {
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO rental_agreement(rental_agreement_id, customer_id, VIN_number, employee_id, drop_off, price, date_of_agreement, rental_startdate, rental_enddate, license_plate)"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?) ");
            stmt.setInt(1,entity.getRentalAgreementID());
            stmt.setInt(2, entity.getCustomerID());
            stmt.setString(3, entity.getVinNumber());
            stmt.setInt(4, entity.getEmployeeID());
            stmt.setInt(5, entity.getEmployeeID());
            stmt.setString(6, entity.getDropOff());
            stmt.setDouble(7, entity.getPrice());
            stmt.setString(8, entity.getDateOfAgreement());
            stmt.setString(9, entity.getRentalStartdate());
            stmt.setString(10, entity.getRentalEnddate());
            stmt.setString(11, entity.getLicensePlate());

            stmt.executeUpdate();
            System.out.println("rentalagreement has been created");

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("something went wrong");
            return false;

        }

    }


    @Override
    public RentalAgreement getSingleEntityById(int id) throws SQLException {
        String mySQLStatement = "SELECT * FROM rental_agreement WHERE rental_agreement_id='" + id + "'";


        ResultSet resultSet = statement.executeQuery(mySQLStatement);
        RentalAgreement rentalAgreement = null;

        while (resultSet.next()) {
            rentalAgreement = new RentalAgreement(resultSet.getInt("customer_id"),
                    resultSet.getInt("rental_agreement_id"),
                    resultSet.getString("VIN_number"),
                    resultSet.getInt("employee_id"),
                    resultSet.getString("drop_off"),
                    resultSet.getDouble("price"),
                    resultSet.getString("date_of_agreement"),
                    resultSet.getString("rental_startdate"),
                    resultSet.getString("rental_enddtae"),
                    resultSet.getString("license_plate"));
        }
        return rentalAgreement;
    }

    @Override
    public ArrayList<RentalAgreement> getAllEntities(){


        String mySQLStatement = "SELECT * from rental_agreement";
        ArrayList<RentalAgreement> rentalAgreements = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM rental_agreement_id");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int rentalAgreementID = rs.getInt("rental_agreement_id");
                int customerID = rs.getInt("customer_id");
                int employeeID = rs.getInt("employee_id");
                String vinNumber = rs.getString("VIN_number");
                double price = rs.getDouble("price");
                String dateOfAgreement = rs.getString("date_of_agreement");
                String rentalStartdate = rs.getString("rental_startdate");
                String rentalEnddate = rs.getString("rental_enddate");
                String dropOff = rs.getString("drop_off");
                String licensePlate = rs.getString("license_plate");

               RentalAgreement newRentalAgreement = new RentalAgreement(rentalAgreementID, customerID, vinNumber, employeeID, dropOff, price, dateOfAgreement, rentalStartdate, rentalEnddate, licensePlate);
                rentalAgreements.add(newRentalAgreement);
            }

        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("something went wrong");

        }
        return rentalAgreements;
    }


    @Override
    public boolean update(RentalAgreement entity) {
        return false;
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        String mySQLStatement = "DELETE FROM rental_agreement WHERE rental_agreement_ID='" + id + "'";
        statement.executeUpdate(mySQLStatement);
        return false;
    }
}
