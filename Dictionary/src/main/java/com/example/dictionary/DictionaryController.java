package com.example.dictionary;

<<<<<<< Updated upstream
import javafx.fxml.FXML;
import javafx.scene.control.Label;
=======
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.ResourceBundle;
>>>>>>> Stashed changes

public class DictionaryController {
    @FXML
    private Label welcomeText;a

    @FXML
<<<<<<< Updated upstream
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
=======
    public void study(ActionEvent actionEvent) throws Exception {
        BorderPane pane = FXMLLoader.load(getClass().getResource("Study.fxml"));
        mainContent.getChildren().setAll(pane);
>>>>>>> Stashed changes
    }
}