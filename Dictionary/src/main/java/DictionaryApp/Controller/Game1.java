package DictionaryApp.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class Game1 implements Initializable {
  @FXML
  private AnchorPane menuPane;
  @FXML
  private AnchorPane gamePane;

  @FXML
  public void start() {
    menuPane.setVisible(false);
    gamePane.setVisible(true);
  }

  @FXML
  public void initialize(URL url, ResourceBundle resourceBundle) {

  }
}
