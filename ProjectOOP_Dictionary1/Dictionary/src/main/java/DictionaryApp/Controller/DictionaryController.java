package DictionaryApp.Controller;

import DictionaryApp.Feature.SpeechEngine;
import DictionaryApp.Feature.WordList;
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
    protected static WordList wordList = new WordList();
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
        this.openScene((Stage)studyButton.getScene().getWindow(), "/Views/Study.fxml");
    }
}