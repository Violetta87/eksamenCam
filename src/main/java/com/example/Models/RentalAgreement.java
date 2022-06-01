package com.example.Models;

import java.sql.Date;
import java.time.LocalDate;

public class RentalAgreement {

    private int rentalAgreementID;
    private int customerID;
    private String vinNumber;
    private int employeeID;
    private String dropOff;
    private double price;
    private String dateOfAgreement;
    private String rentalStartdate;
    private String rentalEnddate;
    private String licensePlate;


    public RentalAgreement(int rentalAgreementID, int customerID, String vinNumber, int employeeID, String dropOff, double price, String dateOfAgreement, String rentalStartdate, String rentalEnddate, String licensePlate) {
        this.rentalAgreementID = rentalAgreementID;
        this.customerID = customerID;
        this.vinNumber = vinNumber;
        this.employeeID = employeeID;
        this.dropOff = dropOff;
        this.price = price;
        this.dateOfAgreement = dateOfAgreement;
        this.rentalStartdate = rentalStartdate;
        this.rentalEnddate = rentalEnddate;
        this.licensePlate = licensePlate;
    }

    @Override
    public String toString() {
        return "RentalAgreement{" +
                "rentalAgreementID=" + rentalAgreementID +
                ", customerID=" + customerID +
                ", vinNumber='" + vinNumber + '\'' +
                ", employeeID=" + employeeID +
                ", dropOff='" + dropOff + '\'' +
                ", price=" + price +
                ", dateOfAgreement='" + dateOfAgreement + '\'' +
                ", rentalStartdate='" + rentalStartdate + '\'' +
                ", rentalEnddate='" + rentalEnddate + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                '}';
    }

    public int getRentalAgreementID() {
        return rentalAgreementID;
    }

    public void setRentalAgreementID(int rentalAgreementID) {
        this.rentalAgreementID = rentalAgreementID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getDropOff() {
        return dropOff;
    }

    public void setDropOff(String dropOff) {
        this.dropOff = dropOff;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDateOfAgreement() {
        return dateOfAgreement;
    }

    public void setDateOfAgreement(String dateOfAgreement) {
        this.dateOfAgreement = dateOfAgreement;
    }

    public String getRentalStartdate() {
        return rentalStartdate;
    }

    public void setRentalStartdate(String rentalStartdate) {
        this.rentalStartdate = rentalStartdate;
    }

    public String getRentalEnddate() {
        return rentalEnddate;
    }

    public void setRentalEnddate(String rentalEnddate) {
        this.rentalEnddate = rentalEnddate;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
