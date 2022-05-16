package Services;
import Models.Employee;
import Repositiories.UserRepository;
import org.springframework.ui.Model;

public class LoginService {
    private UserRepository userRepository = new UserRepository();

    public Employee employeeLogin(String username, String password){
        Employee employee = userRepository.getUser(username, password);

        return user;
    }
}
