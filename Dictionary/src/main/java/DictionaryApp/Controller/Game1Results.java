package DictionaryApp.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

import static java.lang.String.*;

public class Game1Results {

    @FXML
    private AnchorPane Game1Results;
    @FXML
    public Label diem;
    public ProgressIndicator dung;
    public ProgressIndicator sai;

    @FXML
    public void initialize() {
        diem.setText(valueOf(Game1.correct) + "/" + valueOf(Game1.counter + 1));
        float dungValue = Float.parseFloat(new String(valueOf(Game1.correct))) / (Game1.counter + 1);
        float saiValue = Float.parseFloat(new String(valueOf(Game1.wrong))) / (Game1.counter + 1);
        dung.setProgress(dungValue);
        sai.setProgress(saiValue);
        dung.setTooltip(new Tooltip(String.format("%.2f%%", dungValue * 100)));
        sai.setTooltip(new Tooltip(String.format("%.2f%%", saiValue * 100)));
    }

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
