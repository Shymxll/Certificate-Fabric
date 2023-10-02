module com.example.certificatefabric {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.certificatefabric to javafx.fxml;
    exports com.example.certificatefabric;
    exports com.example.certificatefabric.controller;
    opens com.example.certificatefabric.controller to javafx.fxml;
}