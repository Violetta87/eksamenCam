package Repositiories;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.sql.*;

public class CreateConnectionMySQL {

    public static Connection createConnectionToMySQL() {
        // tables er oprettet i DB
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bilabonnementDB", "root", "fullstackpassword123#");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static ResultSet createQuery(String queryString, Statement statement) {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(queryString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public static Statement createStatement() {
        Connection connection = createConnectionToMySQL();

        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }
/*
    public static boolean createEmployeeRole(String employeeRole) throws SQLException {
        Statement statement = createStatement();
        String mySQLStatement = "INSERT INTO employee_role (employee_role) VALUES ('" + employeeRole + "')";
        statement.executeUpdate(mySQLStatement);
        return true;
    }
*/
}
