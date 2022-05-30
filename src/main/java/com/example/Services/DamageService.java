package com.example.Services;

import com.example.Models.DamageReport;
import com.example.Repositiories.DamageRepository;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class DamageService {
    private DamageRepository damageRepository = new DamageRepository();

    public DamageReport createDamageReportObject(int employeeID, int rentalAgreementID, int kilometersExceeded, double damageCost, String damages, Date date) {
        return new DamageReport(employeeID, rentalAgreementID, kilometersExceeded, damageCost, damages, date);
    }

    public void insertDamageReportDB(DamageReport damageReport) throws SQLException {
        damageRepository.create(damageReport);
    }

}
