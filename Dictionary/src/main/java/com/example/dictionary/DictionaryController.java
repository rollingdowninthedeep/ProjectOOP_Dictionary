package com.example.dictionary;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import jdk.internal.access.JavaIOFileDescriptorAccess;

import java.io.IOException;

public class DictionaryController {
    public static DatabaseConnection databaseConnection = new DatabaseConnection();

    @FXML
    private AnchorPane mainContent;
    @FXML
    public void study(ActionEvent actionEvent) throws Exception {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Study.fxml"));
        mainContent.getChildren().setAll(pane);
    }
    @FXML
    public void play(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Game.fxml"));
        mainContent.getChildren().setAll(pane);
    }

    @FXML
    public void exit(ActionEvent actionEvent) {
        Platform.exit();
    }
}
