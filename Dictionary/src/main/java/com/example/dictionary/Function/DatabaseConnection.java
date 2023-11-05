package com.example.dictionary.Function;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaseLink;

    public DatabaseConnection() {
        String databaseName = "dictionarydata"; // sửa thành tên của database
        String databaseUsername = "root";       // sửa thành tên username
        String databasePassword = "Quyen@030204"; // sửa thành mật khẩu của connect
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
