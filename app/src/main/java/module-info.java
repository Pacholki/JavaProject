module com.pacholki {

    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    
    requires com.fasterxml.jackson.databind;

    requires transitive MaterialFX;

    opens com.pacholki to javafx.fxml;
    opens com.pacholki.controllers to javafx.fxml;

    exports com.pacholki;
    exports com.pacholki.controllers;
    exports com.pacholki.pane;
    exports com.pacholki.pane.league;
}
