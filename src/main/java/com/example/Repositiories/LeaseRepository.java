package com.example.Repositiories;

import java.sql.Connection;

public class LeaseRepository {
    private Connection connection = CreateConnectionMySQL.createConnectionToMySQL();
}