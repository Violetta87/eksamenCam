package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class Demo1Application {

    public Demo1Application() throws SQLException {
    }

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }
}
