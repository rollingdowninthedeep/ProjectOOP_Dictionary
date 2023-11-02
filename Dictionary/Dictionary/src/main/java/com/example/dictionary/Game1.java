package com.example.dictionary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class Game1 {

    @FXML
    private AnchorPane game1;

    public void back(ActionEvent actionEvent) throws IOException {
        try {
            AnchorPane scene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Game.fxml")));
            game1.getChildren().setAll(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
