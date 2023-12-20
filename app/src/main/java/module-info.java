module com.pacholki {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.pacholki to javafx.fxml;
    exports com.pacholki;
}
