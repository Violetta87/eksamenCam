package com.example.Models;

public class DamageReport {
    private int employeeID;
    private int rentalAgreementID;
    private int kilometersExceeded;
    private int damage_cost;
    private String damages;
    private String date;

    public DamageReport(int employeeID, int rentalAgreementID, int kilometersExceeded, int damage_cost, String damages, String date) {
        this.employeeID = employeeID;
        this.rentalAgreementID = rentalAgreementID;
        this.kilometersExceeded = kilometersExceeded;
        this.damage_cost = damage_cost;
        this.damages = damages;
        this.date = date;
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

    public int getKilometersExceeded() {
        return kilometersExceeded;
    }

    public void setKilometersExceeded(int kilometersExceeded) {
        this.kilometersExceeded = kilometersExceeded;
    }

    public int getDamage_cost() {
        return damage_cost;
    }

    public void setDamage_cost(int damage_cost) {
        this.damage_cost = damage_cost;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDamages() {
        return damages;
    }

    public void setDamages(String damages) {
        this.damages = damages;
    }

    @Override
    public String toString() {
        return "DamageReport{" +
                "employeeID=" + employeeID +
                ", rentalAgreementID=" + rentalAgreementID +
                ", kilometersExceeded=" + kilometersExceeded +
                ", damage_cost=" + damage_cost +
                ", damages='" + damages + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
