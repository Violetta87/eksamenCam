package com.example.Models;

public class Car {
String model;
String brand;
int carbonEmission;
int registrationCost;
String equipmentLevel;
boolean isRented;
boolean isDamaged;

public Car(String model,String brand, int carbonEmission, int registrationCost, String equipmentLevel, boolean isRented, boolean isDamaged){
    this.model=model;
    this.brand=brand;
    this.carbonEmission=carbonEmission;
    this.registrationCost=registrationCost;
    this.equipmentLevel=equipmentLevel;
    this.isRented=isRented;
    this.isDamaged=isDamaged;
}

    public void setModel(String model) {this.model = model;}

    public void setBrand(String brand) {this.brand = brand;}

    public void setCarbonEmission(int carbonEmission) {this.carbonEmission = carbonEmission;}

    public void setRegistrationCost(int registrationCost) {this.registrationCost = registrationCost;}

    public void setEquipmentLevel(String equipmentLevel) {this.equipmentLevel = equipmentLevel;}

    public void setRented(boolean rented) {isRented = rented;}

    public void setDamaged(boolean damaged) {isDamaged = damaged;}

    public String getModel() {return model;}

    public String getBrand() {return brand;}

    public int getCarbonEmission() {return carbonEmission;}

    public int getRegistrationCost() {return registrationCost;}

    public String getEquipmentLevel() {return equipmentLevel;}

    public boolean isRented() {return isRented;}

    public boolean isDamaged() {return isDamaged;}

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", carbonEmission=" + carbonEmission +
                ", registrationCost=" + registrationCost +
                ", equipmentLevel='" + equipmentLevel + '\'' +
                ", isRented=" + isRented +
                ", isDamaged=" + isDamaged +
                '}';
    }
}

