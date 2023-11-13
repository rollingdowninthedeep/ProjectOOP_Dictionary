package com.example.dictionary;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaseLink;

    public DatabaseConnection() {
<<<<<<< Updated upstream:Dictionary/src/main/java/com/example/dictionary/DatabaseConnection.java
        String databaseName = "dictionarydata";
        String databaseUsername = "root";
        String databasePassword = "Quyen@030204";
        String url = "jdbc:mysql://localhost:3306/" + databaseName;
=======
        String databaseName = "thanh";
        String databaseUsername = "root";
        String databasePassword = "Thanh@2k4";
        String url = "jdbc:mysql://127.0.0.1:3306/" + databaseName;
>>>>>>> Stashed changes:Dictionary/src/main/java/DictionaryApp/Feature/DatabaseConnection.java
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
