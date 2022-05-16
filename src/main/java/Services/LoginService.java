package Services;
import Models.Employee;
import Repositiories.UserRepository;
import org.springframework.ui.Model;

import java.sql.SQLException;

public class LoginService {
    private UserRepository userRepository = new UserRepository();

    public Employee employeeLogin(String username, String password) throws SQLException {
        Employee employee = userRepository.getUser(username, password);

        return employee;
    }
}
