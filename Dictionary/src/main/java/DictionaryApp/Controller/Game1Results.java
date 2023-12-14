package DictionaryApp.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;

import java.net.URL;
import java.util.ResourceBundle;

public class Game1Results extends Display{
    @FXML
    public Label diem;
    public ProgressIndicator dung;
    public ProgressIndicator sai;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        diem.setText(Game1.correct + "/" + (Game1.counter + 1));
        dung.setProgress((float)Game1.correct/(Game1.counter + 1));
        sai.setProgress((float)Game1.wrong/(Game1.counter + 1));
    }

    public void back() {
        try {
            switchScene("/Views/MenuGame1.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}