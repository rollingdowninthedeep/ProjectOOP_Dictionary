module DictionaryApp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;

    requires java.sql;
    requires java.google.speech.api;
    requires jlayer;

  opens DictionaryApp to javafx.fxml;
    exports DictionaryApp;
    exports DictionaryApp.Controller;
    opens DictionaryApp.Controller to javafx.fxml;
    exports DictionaryApp.Feature;
    opens DictionaryApp.Feature to javafx.fxml;
}