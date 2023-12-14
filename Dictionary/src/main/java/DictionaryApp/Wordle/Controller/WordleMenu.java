package DictionaryApp.Wordle.Controller;

import DictionaryApp.Controller.Display;
import DictionaryApp.DictionaryApplication;
import animatefx.animation.AnimationFX;
import animatefx.animation.Tada;
import animatefx.animation.Wobble;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;
import java.util.ResourceBundle;

public class WordleMenu extends Display {
    @FXML
    private ImageView volumeButton;
    @FXML
    private ImageView muteButton;
    @FXML
    private Label title;
    @FXML
    private Button playButton, infoButton, statsButton;

    @FXML
    public void playButtonAction() throws Exception{
        switchScene("/Views/wordle_play.fxml");
    }
    @FXML
    public void infoButtonAction() throws Exception{
        switchScene("/Views/wordle_howto.fxml");
    }
    @FXML
    public void statsButtonAction() throws Exception{
        switchScene("/Views/wordle_stats.fxml");
    }
    @FXML
    public void soundButtonAction(){
        if(!isMute){
            isMute = true;
            muteButton.setVisible(true);
            volumeButton.setVisible(false);

            mediaPlayer.pause();
        } else {
            isMute = false;
            muteButton.setVisible(false);
            volumeButton.setVisible(true);

            mediaPlayer.play();
        }
    }
    @FXML
    public void exitButtonAction(){
        mediaPlayer.stop();
        exitScene();
    }

    private boolean isMute = false;
    public static MediaPlayer mediaPlayer = new MediaPlayer(new Media(DictionaryApplication.class.getResource("/sounds/Fluffing-a-Duck(chosic.com).mp3").toExternalForm()));

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

        mediaPlayer.setCycleCount(999);
        mediaPlayer.setAutoPlay(true);
    }
}