package com.example.Services;

import com.example.Models.DamageReport;
import com.example.Repositiories.DamageRepository;

import java.util.ArrayList;

public class DamageService {
    private DamageRepository damageRepository = new DamageRepository();

    public DamageReport createDamageReportObject(int employeeID, String numberVIN, String chassisNumber, String damages, int kilometersExceeded, String date, int damageCost, int rentalAgreementID) {
        return new DamageReport(employeeID, rentalAgreementID, kilometersExceeded, damageCost, damages, date);
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
