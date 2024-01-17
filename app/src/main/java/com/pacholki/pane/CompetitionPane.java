package com.pacholki.pane;

import com.pacholki.controller.Controller;

public class CompetitionPane extends MyPane {

    private Controller controller;
    private Integer gameweek;
    
    public CompetitionPane(Controller controller) {
        this.controller = controller;
        this.gameweek = currentCompetition.getMaxGameweek();
    }

    public Controller getController() {
        return controller;
    }

    public int getGameweek() {
        return gameweek;
    }

    public void setGameweek(int gameweek){
        this.gameweek = gameweek;
    }
}
