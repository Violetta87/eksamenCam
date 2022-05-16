package com.example.Services;
import com.example.Models.Employee;
import com.example.Repositiories.UserRepository;

import java.sql.SQLException;

public class LoginService {
    private UserRepository userRepository = new UserRepository();

    public Employee employeeLogin(String username, String password) throws SQLException {
        Employee employee = userRepository.getUser(username, password);

        return employee;
    }
}
