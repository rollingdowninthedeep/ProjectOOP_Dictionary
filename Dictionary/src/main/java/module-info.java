module DictionaryApp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires org.kordamp.ikonli.core;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.materialdesign2;

    requires java.sql;
    requires java.google.speech.api;
    requires jlayer;
    requires AnimateFX;

    opens DictionaryApp to javafx.fxml;
    opens DictionaryApp.Controller to javafx.fxml;
    opens DictionaryApp.Feature to javafx.fxml;
    opens DictionaryApp.Wordle to javafx.fxml;
    opens DictionaryApp.Wordle.Feature to javafx.fxml;
    opens DictionaryApp.Wordle.Item to javafx.fxml;
    opens DictionaryApp.Wordle.Controller to javafx.fxml;
    exports DictionaryApp;
}