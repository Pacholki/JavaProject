package com.pacholki.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Team {
    
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

    public class TeamTableRow {

        private String name;
        private int gamesPlayed;
        private int gamesWon;
        private int gamesDrawn;
        private int gamesLost;
        private int goalsFor;
        private int goalsAgainst;
        private int points;
        public TeamTableRow(Team team, Integer gameweek){
            this.name = team.name;
            this.gamesPlayed = team.gamesPlayed[gameweek];
            this.gamesWon = team.gamesWon[gameweek];
            this.gamesDrawn = team.gamesDrawn[gameweek];
            this.gamesLost = team.gamesLost[gameweek];
            this.goalsFor = team.goalsFor[gameweek];
            this.goalsAgainst = team.goalsAgainst[gameweek];
            this.points = team.points[gameweek];
        }
    }
    public String getName() {
        return name;
    }

    // ---------------------------------------------

    public void setName(String name) {
        this.name = name;
    }

    // ---------------------------------------------

    public void setGamesPlayed(Integer gameweek) {
        gamesPlayed[gameweek] = gamesPlayed[gameweek - 1] + 1;
    }

    public void setGamesWon(Integer gameweek, int result) {
        gamesWon[gameweek] = gamesWon[gameweek - 1] + result;
    }

    public void setGamesDrawn(Integer gameweek, int result) {
        gamesDrawn[gameweek] = gamesDrawn[gameweek - 1] + result;
    }

    public void setGamesLost(Integer gameweek, int result) {
        gamesLost[gameweek] = gamesLost[gameweek - 1] + result;
    }

    public void setGoalsFor(Integer gameweek, int goals) {
        goalsFor[gameweek] = goalsFor[gameweek - 1] + goals;
    }

    public void setGoalsAgainst(Integer gameweek, int goals) {
        goalsAgainst[gameweek] = goalsAgainst[gameweek - 1] + goals;
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

    //-------------------------------------------------

    public String toString() {
        return name;
    }
}
