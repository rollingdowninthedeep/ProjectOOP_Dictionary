package com.example.dictionary;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Study {
  @FXML
  private Button searchButton;
  @FXML
  private Button translateButton;

  @FXML
  public void search() {
    loadNewFXML("Search.fxml");
  }

  @FXML
  public void translate() {
    loadNewFXML("Translate.fxml");
  }

  private void loadNewFXML(String fileName) {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource(fileName));
      Parent root = loader.load();

      // Tạo một stage mới
      Stage stage = new Stage();
      stage.setScene(new Scene(root));
      stage.show();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
