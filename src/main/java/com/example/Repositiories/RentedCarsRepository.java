package com.example.Repositiories;

import com.example.utility.CreateConnectionMySQL;

import java.sql.Connection;

public class RentedCarsRepository {
    Connection connection = CreateConnectionMySQL.createConnectionToMySQL();
}
