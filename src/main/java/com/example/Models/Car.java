package com.example.Models;

public class Car implements Comparable<Car> {
private String carModel;
private String brand;
private int carbonEmission;
private int registrationCost;
private String equipmentLevel;
private Boolean isRented;
private Boolean isSold;
private Boolean isDamaged; // hasDefects
private String chassisNumber;
private int vinNumber;
//nummerplade skal herover - private String licensePlate;

    public Car(String carModel, String brand, int carbonEmission, int registrationCost, String equipmentLevel, boolean isRented, Boolean isSold,boolean isDamaged, String chassisNumber, int vinNumber){
        this.carModel=carModel;
        this.brand=brand;
        this.carbonEmission=carbonEmission;
        this.registrationCost=registrationCost;
        this.equipmentLevel=equipmentLevel;
        this.isRented=isRented;
        this.isSold=isSold;
        this.isDamaged=isDamaged;
        this.chassisNumber=chassisNumber;
        this.vinNumber=vinNumber;
    }


    public void setcarModel(String modelName) {this.carModel = modelName;}

    public void setBrand(String brand) {this.brand = brand;}

    public void setCarbonEmission(int carbonEmission) {this.carbonEmission = carbonEmission;}

    public void setRegistrationCost(int registrationCost) {this.registrationCost = registrationCost;}

    public void setEquipmentLevel(String equipmentLevel) {this.equipmentLevel = equipmentLevel;}

    public void setRented(boolean rented) {isRented = rented;}

    public void setSold(Boolean sold) {
        isSold = sold;
    }

    public void setDamaged(boolean damaged) {isDamaged = damaged;}

    public void setChassisNumber(String chassisNumber) {this.chassisNumber = chassisNumber;}

    public void setVinNumber(int vinNumber) {this.vinNumber = vinNumber;}

    public String getCarModel() {return carModel;}

    public String getBrand() {return brand;}

    public int getCarbonEmission() {return carbonEmission;}

    public int getRegistrationCost() {return registrationCost;}

    public String getEquipmentLevel() {return equipmentLevel;}

    public boolean isRented() {return isRented;}

    public Boolean isSold() {
        return isSold;
    }

    public boolean isDamaged() {return isDamaged;}

    public String getChassisNumber() {return chassisNumber;}
    public int getVinNumber() {return vinNumber;}


    @Override
    public String toString() {
        return "Car{" +
                "carModel='" + carModel + '\'' +
                ", brand='" + brand + '\'' +
                ", carbonEmission=" + carbonEmission +
                ", registrationCost=" + registrationCost +
                ", equipmentLevel='" + equipmentLevel + '\'' +
                ", isRented=" + isRented +
                ", isSold=" + isSold +
                ", isDamaged=" + isDamaged +
                ", chassisNumber=" + chassisNumber +
                ", vinNumber=" + vinNumber +
                '}';
    }

    @Override
    public int compareTo(Car second) {
        if(this.getVinNumber() > second.getVinNumber())
        return 1;
    else if(this.getVinNumber() < second.getVinNumber())
        return -1;
    else return 0;
    }
}

