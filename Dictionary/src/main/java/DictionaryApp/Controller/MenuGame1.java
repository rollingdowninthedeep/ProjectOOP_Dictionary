package DictionaryApp.Controller;

import javafx.fxml.FXML;

public class MenuGame1 extends Display {
    @FXML
    public void start() {
      try {
            switchScene("/Views/Game1.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exit(){
        exitScene();
    }
}
