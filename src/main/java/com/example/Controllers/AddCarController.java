package com.example.Controllers;

import com.example.Models.Car;
import com.example.Repositiories.AddCarsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class AddCarController {

    AddCarsRepository addCarsRepository =new AddCarsRepository();

    @GetMapping("/addCars")
    public String addCars(){ return "add-cars";}

    @PostMapping("/addCars")
    public String create(@ModelAttribute Car car) throws SQLException{
        try {
            addCarsRepository.create(car);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/add";
    }

    @GetMapping("/carList")
    public String notRentedCars(Model model){
        ArrayList<Car> carList = addCarsRepository.getAllEntities();
        model.addAttribute("carList",carList);
        return "carList";
    }

}
