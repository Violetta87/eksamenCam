package com.example.Models;

import java.sql.Date;

public class RentalAgreement {
    private int customerID;
    private int vinNumber;
    private int employeeID;
    private int rentalAgreementID;
    private double price;
    private Date dateOfAgreement;
    private Date rentalStartdate;
    private Date rentalEnddate;
    private boolean isActive;
    private String dropoff;
    private String licensePlate;


    public RentalAgreement(int customerID, int vinNumber, int employeeID, String dropoff, double price, Date dateOfAgreement, Date rentalStartdate, Date rentalEnddate, String licensePlate) {
        this.vinNumber = vinNumber;
        this.employeeID = employeeID;
        this.dropoff = dropoff;
        this.price = price;
        this.dateOfAgreement = dateOfAgreement;
        this.rentalStartdate = rentalStartdate;
        this.rentalEnddate = rentalEnddate;
        this.customerID = customerID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomer(int customerID) {
        this.customerID = customerID;
    }

    public int getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(int vinNumber) {
        this.vinNumber = vinNumber;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getRentalAgreementID() {
        return rentalAgreementID;
    }

    public void setRentalAgreementID(int rentalAgreementID) {
        this.rentalAgreementID = rentalAgreementID;
    }

    public String getDropoff() {
        return dropoff;
    }

    public void setDropoffID(int dropoffID) {
        this.dropoff = dropoff;
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

}