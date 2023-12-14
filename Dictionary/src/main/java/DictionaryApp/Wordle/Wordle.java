package DictionaryApp.Wordle;

import DictionaryApp.Controller.Display;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import DictionaryApp.DictionaryApplication;

import java.io.IOException;

import static javafx.scene.paint.Color.TRANSPARENT;

public class Wordle {
    public static void start(Parent root) throws Exception {
        Scene scene =  new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
}