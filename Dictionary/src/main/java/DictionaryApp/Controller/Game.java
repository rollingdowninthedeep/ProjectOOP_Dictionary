package DictionaryApp.Controller;

import DictionaryApp.Wordle.Wordle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class Game extends Display {
    @FXML
    public void game1() throws Exception {
        openScene("/Views/MenuGame1.fxml");
    }

    @FXML
    public void game2() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Views/wordle-view.fxml"));
        Wordle.start(root);
    }
}
