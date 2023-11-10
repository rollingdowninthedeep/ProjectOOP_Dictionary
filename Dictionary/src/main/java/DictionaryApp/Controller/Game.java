package DictionaryApp.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Game extends DictionaryController implements Initializable {
  @FXML
  private Button game1;
  @FXML
  private Button game2;
  @FXML
  protected AnchorPane gamePane;

  @FXML
  public void game1() {
    try {
      openScene((Stage) gamePane.getScene().getWindow(), "/Views/dictionary-view.fxml");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @FXML
  public void game2() {
    try {
      openScene((Stage) gamePane.getScene().getWindow(), "/Views/dictionary-view.fxml");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

  }
}
