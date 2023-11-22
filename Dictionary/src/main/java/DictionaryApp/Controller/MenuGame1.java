package DictionaryApp.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.PopupWindow;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.util.Objects;

public class MenuGame1 {
    @FXML
    private AnchorPane paneMenu;
    @FXML
    public void start(ActionEvent actionEvent) throws IOException {
      try {
            AnchorPane content = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Views/Game1.fxml")));
            paneMenu.getChildren().clear();
            paneMenu.getChildren().add(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exit(ActionEvent actionEvent)throws IOException {
        try {
            Stage stage = (Stage) paneMenu.getScene().getWindow();
            stage.hide();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
