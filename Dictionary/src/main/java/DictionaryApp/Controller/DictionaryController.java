package DictionaryApp.Controller;

import DictionaryApp.Feature.SpeechEngine;
import DictionaryApp.Feature.WordList;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DictionaryController implements Initializable {
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
    public void openScene(Stage window, String path) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene =  new Scene(root);
        window.setScene(scene);
        window.centerOnScreen();
        window.show();
    }
    @FXML
    public void search(ActionEvent actionEvent) {
        try {
            AnchorPane content = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Views/Search.fxml")));
            pane.getChildren().clear();
            pane.getChildren().add(content);
            searchButton.getStyleClass().add("pressed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void translate(ActionEvent actionEvent) {
        try {
            AnchorPane content = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Views/Translate.fxml")));
            pane.getChildren().clear();
            pane.getChildren().add(content);
            translateButton.getStyleClass().add("pressed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void home(ActionEvent actionEvent) {
        try {
            AnchorPane content = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Views/Home.fxml")));
            pane.getChildren().clear();
            pane.getChildren().add(content);
            homeButton.getStyleClass().add("pressed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void game(ActionEvent actionEvent) {
        try {
            AnchorPane content = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Views/Game.fxml")));
            pane.getChildren().clear();
            pane.getChildren().add(content);
            gameButton.getStyleClass().add("pressed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void account(ActionEvent actionEvent) {
        try {
            AnchorPane content = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(
                "/Views/Account.fxml")));
            pane.getChildren().clear();
            pane.getChildren().add(content);
            translateButton.getStyleClass().add("pressed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void exit(ActionEvent actionEvent) {
        try {
            Platform.exit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            AnchorPane content = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Views/Home.fxml")));
            pane.getChildren().add(content);
            homeButton.getStyleClass().add("pressed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}