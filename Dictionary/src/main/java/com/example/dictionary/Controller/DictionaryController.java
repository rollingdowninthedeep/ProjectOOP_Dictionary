package com.example.dictionary.Controller;

import com.example.dictionary.Function.SpeechEngine;
import com.example.dictionary.Function.WordList;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DictionaryController  {
    @FXML
    private Button studyButton;
    @FXML
    private Button playButton;

    protected static WordList wordList;
    protected static final SpeechEngine speechEngine = new SpeechEngine();
    public void openScene(Stage window, String path) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene =  new Scene(root);
        window.setScene(scene);
        window.centerOnScreen();
        window.show();
    }
    @FXML
    public void study(ActionEvent actionEvent) throws Exception {
        this.openScene((Stage)studyButton.getScene().getWindow(), "Study.fxml");
    }
}