package DictionaryApp.Wordle;

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
    public static MediaPlayer mediaPlayer = new MediaPlayer(new Media(DictionaryApplication.class.getResource("/sounds/Fluffing-a-Duck(chosic.com).mp3").toExternalForm()));

    public static void start(Parent root){
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        scene.setFill(TRANSPARENT);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();

        mediaPlayer.setCycleCount(999);
        mediaPlayer.setAutoPlay(true);
    }
    public static void close(Stage stage){
        mediaPlayer.stop();
        stage.close();
    }
}