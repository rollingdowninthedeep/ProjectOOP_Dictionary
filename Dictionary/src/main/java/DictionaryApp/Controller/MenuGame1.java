package DictionaryApp.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.PopupWindow;

import java.io.IOException;
import java.util.Objects;

public class MenuGame1 {
    @FXML
    private AnchorPane paneMenu;
    @FXML
    public void start(ActionEvent actionEvent)throws IOException {
        try {
            AnchorPane content = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Views/Game1.fxml")));
            paneMenu.getChildren().clear();
            paneMenu.getChildren().add(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exit(ActionEvent actionEvent)throws IOException {

    }
}
