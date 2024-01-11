package com.pacholki.pane;

import com.pacholki.controller.Controller;

public class CompetitionPane extends MyPane {

    private Controller controller;
    
    public CompetitionPane(Controller controller) {
        this.controller = controller;
    }

    public Controller getController() {
        return controller;
    }
}
