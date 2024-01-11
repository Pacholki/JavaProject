package com.pacholki.pane;

import com.pacholki.entity.Competition;
import com.pacholki.entity.Team;

public class MyPane {
    
    protected static Competition currentCompetition;
    protected static Team currentTeam;

    public Competition getCurrentCompetition() {
        return currentCompetition;
    }

    public Team getCurrentTeam() {
        return currentTeam;
    }
}
