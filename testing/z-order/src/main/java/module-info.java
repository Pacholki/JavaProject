module com.pacholki {

    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    requires MaterialFX;

    opens com.pacholki to javafx.fxml;
    opens com.pacholki.controller to javafx.fxml;

    exports com.pacholki;
    exports com.pacholki.controller;
}
