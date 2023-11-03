package com.example.dictionary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class Game {
    @FXML
    private AnchorPane game;
    public void back(ActionEvent actionEvent) throws IOException {
        try {
            AnchorPane scene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dictionary-view.fxml")));
            game.getChildren().setAll(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void game1(ActionEvent actionEvent) throws IOException {
        try {
            AnchorPane scene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Game1.fxml")));
            game.getChildren().setAll(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
