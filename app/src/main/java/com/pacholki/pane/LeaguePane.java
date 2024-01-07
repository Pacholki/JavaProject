package com.pacholki.pane;

import com.pacholki.controller.Controller;

public class LeaguePane {

    private Controller controller;
    
    public LeaguePane(Controller controller) {
        this.controller = controller;
    }

    public Controller getController() {
        return controller;
    }
}
