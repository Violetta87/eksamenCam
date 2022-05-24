package com.example.Controllers;

import com.example.Models.Employee;
import com.example.Services.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
public class LoginController {
    private LoginService loginService = new LoginService();

    @GetMapping("/")
    public String Index() {
        return "login";
    }

    @PostMapping("/")
    public String getLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession httpSession) throws SQLException {
        Employee employee = loginService.employeeLogin(username, password);
        httpSession.setAttribute("user", employee);

        if (employee.getEmploymentRoleID() == 1){
            return "redirect:/add";
        }
        else if (employee.getEmploymentRoleID() == 2){
            return "redirect:/dashboard";
        }
        else if (employee.getEmploymentRoleID() == 3){
            return "redirect:/add-defects";
        }
        else {
            return "login";
        }
    }

    @GetMapping("/log-out")
    public String logOut(HttpSession httpSession) {
        httpSession.removeAttribute("user");
        return "redirect:/";
    }
}
