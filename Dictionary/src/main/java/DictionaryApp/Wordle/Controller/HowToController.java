
package DictionaryApp.Wordle.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import DictionaryApp.Wordle.Item.LetterLabel;
import DictionaryApp.Wordle.Item.LetterStyle.DisplayType;
import DictionaryApp.DictionaryApplication;

import java.io.IOException;
import java.net.URL;


public class HowToController {

    @FXML
    private TilePane tilepane1;
    @FXML
    private TilePane tilepane2;
    @FXML
    private TilePane tilepane3;
    @FXML
    private Button switchButton;
    
    public void initialize() {
        
        LetterLabel ll = (LetterLabel)tilepane1.getChildren().get(0);
        ll.setLetterDisplay(DisplayType.MATCHING);
        ll = (LetterLabel)tilepane2.getChildren().get(1);
        ll.setLetterDisplay(DisplayType.PARTIALMATCH);
        ll = (LetterLabel)tilepane3.getChildren().get(3);
        ll.setLetterDisplay(DisplayType.NOMATCH);

        URL url = DictionaryApplication.class.getResource("/images/reject.png");
        ImageView imageView = new ImageView(new Image(url.toString()));
        imageView.setFitWidth(30);
        imageView.setFitHeight(30);
        switchButton.setGraphic(imageView);
    }

    @FXML
    private void switchToWordle() throws IOException {
        WordleMenu.setScene((Stage) switchButton.getScene().getWindow(), "/Views/wordle-view");
    }
    
}
