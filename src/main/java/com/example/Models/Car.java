package com.example.Models;

public class Car {
String carModel;
String brand;
int carbonEmission;
int registrationCost;
String equipmentLevel;
Boolean isRented;
Boolean isDamaged;

    public Car(String carModel,String brand, String carbonEmission, String registrationCost, String equipmentLevel, String isRented, String isDamaged) {
        this.carModel = carModel;
        this.brand = brand;
        this.carbonEmission = Integer.parseInt(carbonEmission);
        this.registrationCost = Integer.parseInt(registrationCost);
        this.equipmentLevel = equipmentLevel;
        if (isRented.equals("yes"))
        this.isRented = true;
        else {
        this.isRented = false;
        if (isDamaged.equals("no"))
            this.isDamaged = false;

        }
    }
    public Car(String carModel, String brand, int carbonEmission, int registrationCost, String equipmentLevel, boolean isRented, boolean isDamaged){
        this.carModel=carModel;
        this.brand=brand;
        this.carbonEmission=carbonEmission;
        this.registrationCost=registrationCost;
        this.equipmentLevel=equipmentLevel;
        this.isRented=isRented;
        this.isDamaged=isDamaged;
    }


    public void setcarModel(String modelName) {this.carModel = modelName;}

    public void setBrand(String brand) {this.brand = brand;}

    public void setCarbonEmission(int carbonEmission) {this.carbonEmission = carbonEmission;}

    public void setRegistrationCost(int registrationCost) {this.registrationCost = registrationCost;}

    public void setEquipmentLevel(String equipmentLevel) {this.equipmentLevel = equipmentLevel;}

    public void setRented(boolean rented) {isRented = rented;}

    public void setDamaged(boolean damaged) {isDamaged = damaged;}

    public String getmodelName() {return carModel;}

    public String getBrand() {return brand;}

    public int getCarbonEmission() {return carbonEmission;}

    public int getRegistrationCost() {return registrationCost;}

    public String getEquipmentLevel() {return equipmentLevel;}

    public boolean isRented() {return isRented;}

    public boolean isDamaged() {return isDamaged;}

    @Override
    public String toString() {
        return "Car{" +
                "model='" + carModel + '\'' +
                ", brand='" + brand + '\'' +
                ", carbonEmission=" + carbonEmission +
                ", registrationCost=" + registrationCost +
                ", equipmentLevel='" + equipmentLevel + '\'' +
                ", isRented=" + isRented +
                ", isDamaged=" + isDamaged +
                '}';
    }
}

