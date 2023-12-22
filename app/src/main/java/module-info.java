module com.pacholki {
    
    requires MaterialFX;
    // this was such a fucking annoying part of the project OMGGGGG
    // something about changing materialfx to MaterialFX and it immediately compling feels so unfair, but so rewarding at the same time
    // at least i've learned how it is done :)
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens com.pacholki to javafx.fxml;
    opens com.pacholki.controllers to javafx.fxml;
    exports com.pacholki;
    exports com.pacholki.controllers;
}
