package com.example.dictionary;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Study implements Initializable {
    @FXML
    private AnchorPane scene;
    @FXML
    private StackPane contentArea;
    @FXML
    private Button searchButton;
    @FXML
    private Button translateButton;
    @FXML
    private Button backButton;

    @FXML
    public void search() {
      try {
        AnchorPane content = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Search.fxml")));
        contentArea.getChildren().setAll(content);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    @FXML
    public void translate() {
      try {
        AnchorPane content = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Translate.fxml")));
        contentArea.getChildren().setAll(content);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    @FXML
    public void back() {
      try {
        AnchorPane scene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dictionary-view.fxml")));
        this.scene.getChildren().setAll(scene);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            AnchorPane content = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Translate.fxml")));
            contentArea.getChildren().setAll(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
