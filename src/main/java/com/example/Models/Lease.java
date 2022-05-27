package com.example.Models;

import java.sql.Date;

public class Lease {
    private Customer customer;
    private int carID;
    private int employeeID;
    private int leaseID;
    private int dropoffID;
    private double price;
    private Date dateOfAgreement;
    private Date rentalStartdate;
    private Date rentalEnddate;
    private boolean isActive;

    public Lease(Customer customer, int carID, int employeeID, int leaseID, int dropoffID, double price, Date dateOfAgreement, Date rentalStartdate, Date rentalEnddate, boolean isActive) {
        this.customer = customer;
        this.carID = carID;
        this.employeeID = employeeID;
        this.leaseID = leaseID;
        this.dropoffID = dropoffID;
        this.price = price;
        this.dateOfAgreement = dateOfAgreement;
        this.rentalStartdate = rentalStartdate;
        this.rentalEnddate = rentalEnddate;
        this.isActive = isActive;
    }

    public Customer getCustomerID() {
        return customer;
    }

    public void setCustomerID(int customerID) {
        this.customer = customer;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getSubscriptionID() {
        return leaseID;
    }

    public void setSubscriptionID(int subscriptionID) {
        this.leaseID = subscriptionID;
    }

    public int getDropoffID() {
        return dropoffID;
    }

    public void setDropoffID(int dropoffID) {
        this.dropoffID = dropoffID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDateOfAgreement() {
        return dateOfAgreement;
    }

    public void setDateOfAgreement(Date dateOfAgreement) {
        this.dateOfAgreement = dateOfAgreement;
    }

    public Date getRentalStartdate() {
        return rentalStartdate;
    }

    public void setRentalStartdate(Date rentalStartdate) {
        this.rentalStartdate = rentalStartdate;
    }

    public Date getRentalEnddate() {
        return rentalEnddate;
    }

    public void setRentalEnddate(Date rentalEnddate) {
        this.rentalEnddate = rentalEnddate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}