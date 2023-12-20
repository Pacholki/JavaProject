package com.pacholki;

import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToLeagueOverview() throws IOException {
        App.setRoot("leagueOverview");
    }
}