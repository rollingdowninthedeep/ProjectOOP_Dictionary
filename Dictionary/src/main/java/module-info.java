module com.example.dictionary {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;

    requires java.sql;
    requires java.google.speech.api;
    requires jlayer;

    opens com.example.dictionary to javafx.fxml;
    exports com.example.dictionary;
    exports com.example.dictionary.Controller;
    opens com.example.dictionary.Controller to javafx.fxml;
    exports com.example.dictionary.Function;
    opens com.example.dictionary.Function to javafx.fxml;
}