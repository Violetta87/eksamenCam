package com.example.Services;

import com.example.Models.RentalAgreement;
import com.example.Repositiories.RentalAgreementRepository;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class WebRequestService {
    public void uploadRentalAgreement(WebRequest dataFromForm)  {
        RentalAgreementRepository rap = new RentalAgreementRepository();

        int rentalAgreementID = Integer.parseInt(dataFromForm.getParameter("rentalAgreementID"));
        String vinNumber = dataFromForm.getParameter("rentalCar");
        int customerID= Integer.parseInt(dataFromForm.getParameter("customerID"));
        int employeeID = Integer.parseInt(dataFromForm.getParameter("employeeID"));
        String dateOfAgreement = dataFromForm.getParameter("dateOfAgreement");
        String rentalStartDate = dataFromForm.getParameter("rentalStartDate");
        String rentalEndDate = dataFromForm.getParameter("rentalEndDate");
        String dropOff = dataFromForm.getParameter("dropOff");
        double price = Double.parseDouble(dataFromForm.getParameter("price"));
        String licensePlate =dataFromForm.getParameter("licensePlate");

        RentalAgreement rentalAgreement= new RentalAgreement(rentalAgreementID,customerID,vinNumber,employeeID,dropOff,price,dateOfAgreement,rentalStartDate,rentalEndDate,licensePlate);
        rap.create(rentalAgreement);
    }
}
