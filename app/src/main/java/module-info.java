module com.pacholki {
    
    requires MaterialFX;

    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens com.pacholki to javafx.fxml;
    opens com.pacholki.controllers to javafx.fxml;

    exports com.pacholki;
    exports com.pacholki.controllers;
}
