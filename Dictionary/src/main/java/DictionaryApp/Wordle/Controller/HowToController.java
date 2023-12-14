
package DictionaryApp.Wordle.Controller;

import DictionaryApp.Controller.Display;
import DictionaryApp.DictionaryApplication;
import DictionaryApp.Wordle.Item.LetterLabel;
import DictionaryApp.Wordle.Item.LetterStyle.DisplayType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

import java.net.URL;
import java.util.ResourceBundle;


public class HowToController extends Display {

    @FXML
    private TilePane tilepane1;
    @FXML
    private TilePane tilepane2;
    @FXML
    private TilePane tilepane3;
    @FXML
    private Button switchButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LetterLabel ll = (LetterLabel)tilepane1.getChildren().get(0);
        ll.setLetterDisplay(DisplayType.MATCHING);
        ll = (LetterLabel)tilepane2.getChildren().get(1);
        ll.setLetterDisplay(DisplayType.PARTIALMATCH);
        ll = (LetterLabel)tilepane3.getChildren().get(3);
        ll.setLetterDisplay(DisplayType.NOMATCH);

        URL url1 = DictionaryApplication.class.getResource("/images/reject.png");
        assert url1 != null;
        ImageView imageView = new ImageView(new Image(url1.toString()));
        imageView.setFitWidth(30);
        imageView.setFitHeight(30);
        switchButton.setGraphic(imageView);
    }

    @FXML
    private void switchToWordle() throws Exception {
        switchScene("/Views/wordle-view.fxml");
    }
}
