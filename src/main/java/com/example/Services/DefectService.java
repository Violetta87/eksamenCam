package com.example.Services;

import com.example.Models.DefectReport;
import com.example.Repositiories.DefectRepository;

import java.util.ArrayList;

public class DefectService {
    private DefectRepository defectRepository = new DefectRepository();

    public DefectReport createDamageReportObject(int employeeID, String numberVIN, String chassisNumber, String damages, int kilometersExceeded, String date, int damageCost, int rentalAgreementID) {
        return new DefectReport(employeeID, rentalAgreementID, kilometersExceeded, damageCost, damages, date);
    }

    public ArrayList<Integer> damagesStringToIntegerArrayList(String damages) {
        String noWhiteSpaces = damages.replaceAll("//s", "");
        String[] damageIDAsStringArray = noWhiteSpaces.split(",");
        ArrayList<Integer> damageIDs = new ArrayList<>();

        for (int i = 0; i < damageIDAsStringArray.length; i++) {
            damageIDs.add(Integer.parseInt(damageIDAsStringArray[i]));
        }
        return damageIDs;
    }

    public int calculateDamageCost(ArrayList<Integer> DamageIDs) {
        int total_cost = 0;

        for (int i = 0; i < DamageIDs.size(); i++) {
            total_cost += DamageIDs.get(i);
        }
        return total_cost;
    }
}
