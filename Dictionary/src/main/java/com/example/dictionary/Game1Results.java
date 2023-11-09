package com.example.dictionary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class Game1Results {

    @FXML
    private AnchorPane Game1Results;

    public void Back1(ActionEvent actionEvent) {
        try {
            AnchorPane scene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Game.fxml")));
            Game1Results.getChildren().setAll(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
