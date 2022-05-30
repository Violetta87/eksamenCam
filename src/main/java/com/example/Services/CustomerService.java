package com.example.Services;

import com.example.Models.Customer;
import com.example.Repositiories.CustomerRepository;

import java.sql.SQLException;

public class CustomerService {
    private CustomerRepository customerRepository = new CustomerRepository();

    public Customer createCustomerObject(String firstname, String lastname, String address, String email, String phoneNumber) {
        return new Customer(firstname, lastname, address, email, phoneNumber);
    }

    public void insertCustomerDB(Customer customer) {

    }

    public Customer insertAndSelectCustomer(Customer customer) throws SQLException {
        insertCustomerDB(customer);
        return selectCustomerDB(customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getPhoneNumber());
    }

    public Customer selectCustomerDB(String firstname, String lastname, String email, String phoneNumber) throws SQLException {
        return customerRepository.getCustomerByNameEmailPhoneNumber(firstname, lastname, email, phoneNumber);
    }



}
