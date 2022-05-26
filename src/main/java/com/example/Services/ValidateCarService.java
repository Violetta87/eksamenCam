package com.example.Services;

public class ValidateCarService {
    public boolean validateChassis(String chassis) {
        Boolean checker = true;
        for (int i = 0; i < chassis.length(); i++) {
            if (chassis.charAt(i) == 17) {
                checker = true;
            } else {
                checker = false;
            }

        }
        return checker;
    }
}

