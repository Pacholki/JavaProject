package com.pacholki.pane;

import com.pacholki.controller.Controller;

public class CompetitionPane extends MyPane {

    private Controller controller;
    private Integer tableGameweek;
    private Integer fixtureGameweek;
    
    public CompetitionPane(Controller controller) {
        this.controller = controller;
        this.tableGameweek = currentCompetition.getPlayedGameweeks();
        this.fixtureGameweek = currentCompetition.getPlayedGameweeks();
    }

    // ---------------------------------------------

    public Controller getController() {
        return controller;
    }

    public int getTableGameweek() {
        return tableGameweek;
    }

    public int getFixtureGameweek() {
        return fixtureGameweek;
    }

    // ---------------------------------------------

    public void setTableGameweek(int gameweek){
        this.tableGameweek = gameweek;
    }

    public void setFixtureGameweek(int gameweek){
        this.fixtureGameweek = gameweek;
    }
}
