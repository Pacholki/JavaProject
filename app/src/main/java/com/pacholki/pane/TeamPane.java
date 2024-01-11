package com.pacholki.pane;

import com.pacholki.controller.TeamController;
import com.pacholki.entity.Team;

public class TeamPane extends MyPane {
    
    private TeamController controller;

    public TeamPane(TeamController controller) {
        this.controller = controller;
        System.out.println("team changed");
    }

    public Team getCurrentTeam() {
        return currentTeam;
    }

    public TeamController getController() {
        return controller;
    }
}
