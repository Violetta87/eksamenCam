package com.example.Services;

import com.example.Models.Car;
import com.example.Repositiories.FleetRepository;
import java.util.ArrayList;
import java.util.Collections;


public class AddCarService {
    private FleetRepository fleetRepository = new FleetRepository();





    public boolean createCar(Car entity){

        Boolean validCar = false;

        validCar = fleetRepository.create(entity);

        return validCar;
    }

    public ArrayList<Car> showCarList(){
        ArrayList<Car> carList = fleetRepository.getAllEntities();
        Collections.sort(carList);
        return carList;
    }


    public ArrayList<Car> showAvailableCars(){
        ArrayList<Car> carList = fleetRepository.getAllEntities();
        ArrayList<Car> availableCarList = new ArrayList<>();

        for(int i=0;i < carList.size(); i++){
            if(carList.get(i).getRented()==false){
                availableCarList.add(carList.get(i));
            }
        }
        Collections.sort(availableCarList);

     return availableCarList;
    }
}

