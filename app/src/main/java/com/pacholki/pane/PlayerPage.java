package com.pacholki.pane;

import com.pacholki.controller.PlayerPageController;

public class PlayerPage extends Page {

    private static final String FXML_PATH = FXML_DIR + "playerPage.fxml";
    private PlayerPageController controller;

    public PlayerPage(PlayerPageController controller) {this.controller = controller;}
}
