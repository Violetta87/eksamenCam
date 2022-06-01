package com.example.utility;

import java.sql.*;
/*Camella*/

public class CreateConnectionMySQL {

    public static Connection createConnectionToMySQL() {
        String URL = System.getenv("DB_URL");
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");


        // tables er oprettet i DB
        Connection connection = null;


        try {
            connection = DriverManager.getConnection(URL, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
