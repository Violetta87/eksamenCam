package com.example.Repositiories;

import java.sql.*;

public class CreateConnectionMySQL {



    public static Connection createConnectionToMySQL() {
        String URL=System.getenv("DB_URL");
        String user=System.getenv("DB_USER");
        String password=System.getenv("DB_PASSWORD");


        // tables er oprettet i DB
        Connection connection = null;


        try {
            connection = DriverManager.getConnection(URL, user, password);
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
