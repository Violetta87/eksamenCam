package Repositiories;

import Models.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserRepository {
    private CreateConnectionMySQL connectToMySQL = new CreateConnectionMySQL();

    public Statement createStatement() {
        Connection connection = CreateConnectionMySQL.createConnectionToMySQL();

        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    public ResultSet createQuery(String queryString, Statement statement) {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(queryString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public Employee getUser(String username, String password) throws SQLException{
        Employee employee = null;
        Statement statement = createStatement();
        String mySQLStatement = "SELECT employee_id, username, password, employment_role_id FROM employee WHERE username='" + username + "' AND password='" + password + "'";
        ResultSet resultSet = createQuery(mySQLStatement, statement);

        while (resultSet.next()){
            employee = new Employee(resultSet.getString("username"), resultSet.getString("password"), resultSet.getInt("employee_id"), resultSet.getInt("employment_role_id"));
        }

        return employee;
    }
}
