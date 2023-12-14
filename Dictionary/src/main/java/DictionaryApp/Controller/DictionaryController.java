package DictionaryApp.Controller;

import DictionaryApp.Feature.SpeechEngine;
import DictionaryApp.Feature.WordList;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class DictionaryController extends Display {
    @FXML
    private Button homeButton;
    @FXML
    private Button searchButton;
    @FXML
    private Button translateButton;
    @FXML
    private Button gameButton;
    @FXML
    private Button accountButton;
    @FXML
    private Button exitButton;
    @FXML
    private AnchorPane pane;
    protected static WordList wordList = new WordList();
    protected static final SpeechEngine speechEngine = new SpeechEngine();
    @FXML
    public void search() {
        try {
            switchScene(pane, "/Views/Search.fxml");
            searchButton.getStyleClass().add("pressed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void translate() {
        try {
            switchScene(pane, "/Views/Translate.fxml");
            translateButton.getStyleClass().add("pressed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void home() {
        try {
            switchScene(pane, "/Views/Home.fxml");
            homeButton.getStyleClass().add("pressed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void game() {
        try {
            switchScene(pane, "/Views/Game.fxml");
            gameButton.getStyleClass().add("pressed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void account() {
        try {
            switchScene(pane, "/Views/Account.fxml");
            translateButton.getStyleClass().add("pressed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void exit() {
        try {
            Platform.exit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            switchScene(pane, "/Views/Home.fxml");
            homeButton.getStyleClass().add("pressed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}