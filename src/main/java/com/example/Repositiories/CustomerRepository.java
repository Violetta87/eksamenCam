package com.example.Repositiories;

import com.example.Models.Customer;
import com.example.utility.CreateConnectionMySQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerRepository implements CRUDInterface<Customer> {
    private Connection connection = CreateConnectionMySQL.createConnectionToMySQL();
    private Statement statement = CreateConnectionMySQL.createStatement(connection);

    public Customer getCustomerByNameEmailPhoneNumber(String firstname, String lastname, String email, String phoneNumber) throws SQLException {
        String mySQLStatement = "SELECT * customer WHERE firstname='" + firstname + "' AND lastname='" + lastname + "' AND email='" + email + "' AND phonenumber='" + phoneNumber + "'";
        ResultSet resultSet = statement.executeQuery(mySQLStatement);
        Customer customer = null;

        while (resultSet.next()) {
            customer = new Customer(resultSet.getString("firstname"),
                    resultSet.getString("lastname"),
                    resultSet.getString("email"),
                    resultSet.getString("phonenumber"),
                    resultSet.getString("address"));
        }
        return customer;
    }

    @Override
    public boolean create(Customer entity) throws SQLException {
        String mySQLStatement = "INSERT INTO customer (firstname, lastname, email, phonenumber, address) VALUES ('"+ entity.getFirstName() + ", '" + entity.getLastName() + ", '" + entity.getEmail() + ", '" + entity.getPhoneNumber() + ", '" + entity.getAddress() + "')";
        return true;
    }

    @Override
    public Customer getSingleEntityById(int id) throws SQLException {
        String mySQLStatement = "SELECT * FROM customer WHERE customer_id='" + id + "'";
        ResultSet resultSet = statement.executeQuery(mySQLStatement);
        Customer customer = null;

        while (resultSet.next()) {
            customer = new Customer(resultSet.getString("firstname"),
                    resultSet.getString("lastname"),
                    resultSet.getString("email"),
                    resultSet.getString("phonenumber"),
                    resultSet.getString("address"));

        }
        return null;
    }

    @Override
    public ArrayList<Customer> getAllEntities() throws SQLException {
        String mySQLStatement = "SELECT * FROM customer";
        ResultSet resultSet = statement.executeQuery(mySQLStatement);
        ArrayList<Customer> customers = new ArrayList<>();

        while (resultSet.next()) {
            Customer customer = new Customer(resultSet.getString("firstname"),
                    resultSet.getString("lastname"),
                    resultSet.getString("email"),
                    resultSet.getString("phonenumber"),
                    resultSet.getString("address"));
            customers.add(customer);
        }


        return null;
    }

    @Override
    public boolean update(Customer entity) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
