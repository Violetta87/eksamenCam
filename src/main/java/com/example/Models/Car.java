package com.example.Models;

public class Car {
private String carModel;
private String brand;
private int carbonEmission;
private int registrationCost;
private String equipmentLevel;
private Boolean isRented;
private Boolean isSold;
private Boolean isDamaged;


    public Car(String carModel, String brand, int carbonEmission, int registrationCost, String equipmentLevel, boolean isRented, Boolean isSold,boolean isDamaged){
        this.carModel=carModel;
        this.brand=brand;
        this.carbonEmission=carbonEmission;
        this.registrationCost=registrationCost;
        this.equipmentLevel=equipmentLevel;
        this.isRented=isRented;
        this.isSold=isSold;
        this.isDamaged=isDamaged;
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

    public String getmodelName() {return carModel;}

    public String getBrand() {return brand;}

    public int getCarbonEmission() {return carbonEmission;}

    public int getRegistrationCost() {return registrationCost;}

    public String getEquipmentLevel() {return equipmentLevel;}

    public boolean isRented() {return isRented;}

    public Boolean isSold() {
        return isSold;
    }

    public boolean isDamaged() {return isDamaged;}

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
                '}';
    }
}

