package Repositiories;

import java.sql.*;

public class CreateConnectionMySQL {

    public static Connection createConnectionToMySQL() {
        // tables er oprettet i DB
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", "root", "fullstackpassword123#");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
