package com.example.dictionary;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.ResourceBundle;

public class DictionaryController {
    @FXML
    private AnchorPane mainContent;

    @FXML
    public void study(ActionEvent actionEvent) throws Exception {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Translate.fxml"));
        mainContent.getChildren().setAll(pane);
    }
}