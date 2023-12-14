package DictionaryApp.Controller;

import DictionaryApp.DictionaryApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ResourceBundle;

public abstract class Display implements Initializable {
    @FXML
    protected Pane mainPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    protected void openScene(String path) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene =  new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    protected void switchScene(String path) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        Scene scene = new Scene(root);
        Stage stage = (Stage) mainPane.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
    }

    protected void switchScene(Pane pane ,String path) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(path));
        pane.getChildren().clear();
        pane.getChildren().setAll(root);
    }

    protected void exitScene(){
        mainPane.getScene().getWindow().hide();
    }
}
