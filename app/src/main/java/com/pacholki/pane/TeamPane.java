package com.pacholki.pane;

import com.pacholki.controller.TeamController;
import com.pacholki.entity.Team;

public class TeamPane {
    
    private TeamController controller;

    Team currentTeam;

    public TeamPane(TeamController controller) {
        this.controller = controller;
        System.out.println("team changed");
    }
}
