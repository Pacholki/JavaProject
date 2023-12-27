module com.pacholki {

    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    
    requires com.fasterxml.jackson.databind;

    requires transitive MaterialFX;

    opens com.pacholki to javafx.fxml;
    opens com.pacholki.controller to javafx.fxml;

    opens com.pacholki.entity to com.fasterxml.jackson.databind;

    exports com.pacholki;
    exports com.pacholki.controller;
    exports com.pacholki.entity;
    exports com.pacholki.pane;
}
