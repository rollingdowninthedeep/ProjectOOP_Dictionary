package com.example.dictionary;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaseLink;

    public DatabaseConnection() {
        String databaseName = "dictionarydata";
        String databaseUsername = "root";
        String databasePassword = "Quyen@030204";
        String url = "jdbc:mysql://localhost:3306/" + databaseName;
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
