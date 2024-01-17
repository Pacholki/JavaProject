package com.pacholki.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Team extends Entity {

    private static final String FXML_PATH = FXML_DIR + "team.fxml";

    private Competition competition;

    private List<Player> players;
    @JsonProperty("team")
    private String name;
    private int[] gamesPlayed = new int[40];
    private int[] gamesWon = new int[40];
    private int[] gamesDrawn = new int[40];
    private int[] gamesLost = new int[40];
    private int[] goalsFor = new int[40];
    private int[] goalsAgainst = new int[40];
    private int[] points = new int[40];
    // ---------------------------------------------

    public Team(){
        this.players = new ArrayList<>();
    }

    // ---------------------------------------------
    public Competition getCompetition() {
        return competition;
    }

    public String getName() {
        return name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    // ---------------------------------------------

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }
    public void setName(String name) {
        this.name = name;
    }

    // ---------------------------------------------

    public void setGamesPlayed(Integer gameweek, int increase) {
        this.gamesPlayed[gameweek] = gamesPlayed[gameweek-1] + increase;
    }

    public void setGamesWon(Integer gameweek, int increase) {
        gamesWon[gameweek] = gamesWon[gameweek - 1] + increase;
    }

    public void setGamesDrawn(Integer gameweek, int increase) {
        gamesDrawn[gameweek] = gamesDrawn[gameweek - 1] + increase;
    }

    public void setGamesLost(Integer gameweek, int increase) {
        gamesLost[gameweek] = gamesLost[gameweek - 1] + increase;
    }

    public void setGoalsFor(Integer gameweek, int newGoals) {
        goalsFor[gameweek] = goalsFor[gameweek - 1] + newGoals;
    }

    public void setGoalsAgainst(Integer gameweek, int newGoals) {
        goalsAgainst[gameweek] = goalsAgainst[gameweek - 1] + newGoals;
    }

    public void setPoints(Integer gameweek, int newPoints) {
        points[gameweek] = points[gameweek - 1] + newPoints;
    }
    
    //--------------------------------------------------
    
    public int getGamesPlayed(Integer gameweek) {
        return gamesPlayed[gameweek];
    }
    
    public int getGamesWon(Integer gameweek) {
        return gamesWon[gameweek];
    }
    public int getGamesDrawn(Integer gameweek) {
        return gamesDrawn[gameweek];
    }

    public int getGamesLost(Integer gameweek) {
        return gamesLost[gameweek];
    }
    
    public int getGoalsFor(Integer gameweek) {
        return goalsFor[gameweek];
    }

    public int getGoalsAgainst(Integer gameweek) {
        return goalsAgainst[gameweek];
    }
    
    public int getPoints(Integer gameweek) {
        return points[gameweek];
    }

    public TeamTableRow getTableRow(Integer gameweek) {
        return new TeamTableRow(this, gameweek);
    }

    //-------------------------------------------------

    public void addPlayer(Player player) {
        players.add(player);
    }
    @Override
    public void prepareData() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'prepareData'");
    }

    @Override
    public String getFXMLPath() {
        return FXML_PATH;
    }

    // ---------------------------------------------

    public String toString() {
        return name;
    }
}
