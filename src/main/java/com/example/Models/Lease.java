package com.example.Models;

import java.sql.Date;

public class Lease {
    private int customerID;
    private int carID;
    private int employeeID;
    private int subscriptionID;
    private int dropoffID;
    private int price;
    private Date dateOfAgreement;
    private Date rentalStartdate;
    private Date rentalEnddate;
    private String licensePlate;
    private boolean isActive;

    public Lease(int customerID, int carID, int employeeID, int subscriptionID, int dropoffID, int price, Date dateOfAgreement, Date rentalStartdate, Date rentalEnddate, String licensePlate, boolean isActive) {
        this.customerID = customerID;
        this.carID = carID;
        this.employeeID = employeeID;
        this.subscriptionID = subscriptionID;
        this.dropoffID = dropoffID;
        this.price = price;
        this.dateOfAgreement = dateOfAgreement;
        this.rentalStartdate = rentalStartdate;
        this.rentalEnddate = rentalEnddate;
        this.licensePlate = licensePlate;
        this.isActive = isActive;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
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
        return subscriptionID;
    }

    public void setSubscriptionID(int subscriptionID) {
        this.subscriptionID = subscriptionID;
    }

    public int getDropoffID() {
        return dropoffID;
    }

    public void setDropoffID(int dropoffID) {
        this.dropoffID = dropoffID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}