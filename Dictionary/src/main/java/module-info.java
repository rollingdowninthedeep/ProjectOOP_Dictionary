module com.example.dictionary {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;

    requires java.google.speech.api;
    requires jlayer;

  opens com.example.dictionary to javafx.fxml;
    exports com.example.dictionary;
}