package DictionaryApp.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class Game1Results {

    @FXML
    private AnchorPane Game1Results;

    public void back(ActionEvent actionEvent) {
        try {
            AnchorPane content = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Views/MenuGame1.fxml")));
            Game1Results.getChildren().clear();
            Game1Results.getChildren().add(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
