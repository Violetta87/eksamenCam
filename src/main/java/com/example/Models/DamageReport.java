package com.example.Models;

import java.sql.Date;

public class DamageReport {
    private int employeeID;
    private int rentalAgreementID;
    private int kilometersExceeded;
    private Double damageCost;
    private String damageReport;
    private Date date;

    public DamageReport(int employeeID, int rentalAgreementID, int kilometersExceeded, double damageCost, String damageReport, Date date) {
        this.employeeID = employeeID;
        this.rentalAgreementID = rentalAgreementID;
        this.kilometersExceeded = kilometersExceeded;
        this.damageCost = damageCost;
        this.damageReport = damageReport;
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

    public Double getDamageCost() {
        return damageCost;
    }

    public void setDamage_cost(Double damageCost) {
        this.damageCost = damageCost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDamageReport() {
        return damageReport;
    }

    public void setDamages(String damageReport) {
        this.damageReport = damageReport;
    }

}
