package com.example.Services;

/*
public class AddCarService {
    private AddCarsRepository addCarsRepository = new AddCarsRepository();
    private ValidateCarService validateCarService = new ValidateCarService();

    public boolean createCar(Car entity){

        Boolean validCar =false;

           try {
               if(validateCarService.validateChassis(entity.getChassisNumber())==true){
                   validCar = addCarsRepository.create(entity);
               }

           } catch (SQLException e) {
               e.printStackTrace();

           } return validCar;
    }

    public ArrayList<Car> showCarList(){
        ArrayList<Car> carList = addCarsRepository.getAllEntities();
        //Collections.sort(carList);
        return carList;
    }


    public ArrayList<Car> showAvailableCars(){
        ArrayList<Car> carList = addCarsRepository.getAllEntities();
        ArrayList<Car> availableCarList = new ArrayList<>();

        for(int i=0;i < carList.size(); i++){
            if(carList.get(i).getRented()==false){
                availableCarList.add(carList.get(i));
            }
        }
        //Collections.sort(availableCarList);

     return availableCarList;
    }
}
*/
