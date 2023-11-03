package com.example.dictionary;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaseLink;

    public DatabaseConnection() {
        String databaseName = "thanh";
        String databaseUsername = "root";
        String databasePassword = "Thanh@2k4";
        String url = "jdbc:mysql://127.0.0.1:3306/" + databaseName;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUsername, databasePassword);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public Connection getConnection() {
        return databaseLink;
    }
}
