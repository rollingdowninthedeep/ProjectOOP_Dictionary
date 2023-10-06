package com.example.dictionary;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DictionaryController {
    @FXML
    private Label welcomeText;a

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}