package DictionaryApp.Wordle.Controller;

import animatefx.animation.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import DictionaryApp.DictionaryApplication;
import DictionaryApp.Wordle.Wordle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WordleMenu implements Initializable{
    @FXML
    private ImageView volumeButton, muteButton, exitButton;
    @FXML
    private Label title;
    @FXML
    private Button playButton, infoButton, statsButton;

    @FXML
    public void playButtonAction() throws IOException{
        setScene((Stage) playButton.getScene().getWindow(), "/Views/wordle_play");
    }
    @FXML
    public void infoButtonAction() throws IOException{
        setScene((Stage) infoButton.getScene().getWindow(), "/Views/wordle_howto");
    }
    @FXML
    public void statsButtonAction() throws IOException{
        setScene((Stage) statsButton.getScene().getWindow(), "/Views/wordle_stats");
    }
    @FXML
    public void soundButtonAction(){
        if(!isMute){
            isMute = true;
            muteButton.setVisible(true);
            volumeButton.setVisible(false);

            Wordle.mediaPlayer.pause();
        } else {
            isMute = false;
            muteButton.setVisible(false);
            volumeButton.setVisible(true);

            Wordle.mediaPlayer.play();
        }
    }
    @FXML
    public void exitButtonAction(){
        Wordle.close((Stage) exitButton.getScene().getWindow());
    }

    private boolean isMute = false;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AnimationFX playAnimation = new Tada(playButton).setResetOnFinished(true).setCycleCount(999);
        new Wobble(title).setCycleCount(999).setSpeed(0.25).play();
        playButton.setOnMouseEntered(
                e -> playAnimation.play()
        );
        playButton.setOnMouseExited(
                e -> playAnimation.setResetOnFinished(true).stop()
        );
        AnimationFX statsAnimation = new Tada(statsButton).setCycleCount(999);
        statsButton.setOnMouseEntered(
                e -> statsAnimation.play()
        );
        statsButton.setOnMouseExited(
                e -> statsAnimation.setResetOnFinished(true).stop()
        );
        AnimationFX infoAnimation = new Tada(infoButton).setCycleCount(999);
        infoButton.setOnMouseEntered(
                e -> infoAnimation.play()
        );
        infoButton.setOnMouseExited(
                e -> infoAnimation.setResetOnFinished(true).stop()
        );
    }
    public static void setScene(Stage stage, String path) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DictionaryApplication.class.getResource(path + ".fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
    }
}