package com.example.dictionary;

import javafx.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.controlsfx.control.action.Action;

public class Translate {

    @FXML
    public Label label;
    public void action(ActionEvent event) {
        Connection con = DictionaryController.databaseConnection.getConnection();

        String click = "SELECT el FROM wordlist;";

        try {
            Statement statement = con.createStatement();
            ResultSet queryOutput = statement.executeQuery(click);
            while (queryOutput.next()){
                label.setText(queryOutput.getString("el"));
            }
        } catch (Exception e){
            e.getStackTrace();
        }
    }
}
