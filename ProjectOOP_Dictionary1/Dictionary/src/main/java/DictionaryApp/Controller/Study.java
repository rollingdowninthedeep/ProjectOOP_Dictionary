package DictionaryApp.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Study extends DictionaryController implements Initializable {
    @FXML
    protected AnchorPane contentArea;

    @FXML
    public void search() {
        try {
            AnchorPane content = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Views/Search.fxml")));
            contentArea.getChildren().clear();
            contentArea.getChildren().add(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void translate() {
        try {
            AnchorPane content = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Views/Translate.fxml")));
            contentArea.getChildren().clear();
            contentArea.getChildren().add(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void back() {
        try {
            openScene((Stage) contentArea.getScene().getWindow(), "/Views/dictionary-view.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            AnchorPane content = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Views/Translate.fxml")));
            contentArea.getChildren().add(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}