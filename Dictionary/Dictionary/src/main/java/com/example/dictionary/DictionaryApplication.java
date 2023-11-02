package com.example.dictionary;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DictionaryApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("dictionary-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
<<<<<<< Updated upstream:Dictionary/Dictionary/src/main/java/com/example/dictionary/DictionaryApplication.java
        stage.setTitle("LearnEnglish");
=======
        stage.setTitle("Hello!");
>>>>>>> Stashed changes:Dictionary/src/main/java/com/example/dictionary/DictionaryApplication.java
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}