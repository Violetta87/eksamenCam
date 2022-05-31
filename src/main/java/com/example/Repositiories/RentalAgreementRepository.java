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
    public boolean create(RentalAgreement entity) throws SQLException {
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO rental_agreement(customer_id, VIN_number, employee_id, dropoff, price, date_of_agreement, rental_startdate, rental_enddate, license_plate)"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?) ");

            stmt.setInt(1, entity.getCustomerID());
            stmt.setString(2, entity.getVinNumber());
            stmt.setInt(3, entity.getEmployeeID());
            stmt.setInt(4, entity.getEmployeeID());
            stmt.setString(5, entity.getDropOff());
            stmt.setDouble(6, entity.getPrice());
            stmt.setDate(7, entity.getDateOfAgreement());
            stmt.setDate(8, entity.getRentalStartdate());
            stmt.setDate(9, entity.getRentalEnddate());
            stmt.setString(10, entity.getLicensePlate());

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
                    resultSet.getString("VIN_number"),
                    resultSet.getInt("employee_id"),
                    resultSet.getString("drop_off"),
                    resultSet.getDouble("price"),
                    resultSet.getDate("date_of_agreement"),
                    resultSet.getDate("rental_startdate"),
                    resultSet.getDate("rental_enddtae"),
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
                int rentalAgreementID = rs.getInt("rentalAgreementID");
                int customerID = rs.getInt("customerId");
                int employeeID = rs.getInt("employeeID");
                String vinNumber = rs.getString("vinNumber");
                double price = rs.getDouble("price");
                LocalDate dateOfAgreement = rs.getDate("dateOfAgreement");
                Date rentalStartdate = rs.getDate("rentalStartdate");
                Date rentalEnddate = rs.getDate("rentalEnddate");
                String dropOff = rs.getString("dropoff");
                String licensePlate = rs.getString("licensePlate");

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
