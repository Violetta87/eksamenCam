package com.example.demo.Controllers;

import Models.Employee;
import Services.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
public class LoginController {
    private LoginService loginService = new LoginService();

    @GetMapping("")
    public String login(){
        return "login";
    }

    @PostMapping("")
    public String getLogin(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("employment_role") String employmentRole, HttpSession httpSession) throws SQLException {
        Employee employee = loginService.employeeLogin(username, password);
    }
}
