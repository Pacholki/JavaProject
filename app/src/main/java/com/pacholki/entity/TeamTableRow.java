package com.pacholki.entity;

import java.util.List;

public class TeamTableRow {

    public static final List<String> colNames = List.of("Team name", "Played", "Won", "Drawn", "Lost", "GF", "GA", "Points");

    private String name;
    private int gamesPlayed;
    private int gamesWon;
    private int gamesDrawn;
    private int gamesLost;
    private int goalsFor;
    private int goalsAgainst;
    private int points;

    public TeamTableRow(Team team, Integer gameweek){
        this.name = team.getName();
        this.gamesPlayed = team.getGamesPlayed(gameweek);
        this.gamesWon = team.getGamesWon(gameweek);
        this.gamesDrawn = team.getGamesDrawn(gameweek);
        this.gamesLost = team.getGamesLost(gameweek);
        this.goalsFor = team.getGoalsFor(gameweek);
        this.goalsAgainst = team.getGoalsAgainst(gameweek);
        this.points = team.getPoints(gameweek);
    }

    public String getName() {
        return name;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public int getGamesDrawn() {
        return gamesDrawn;
    }

    public int getGamesLost() {
        return gamesLost;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public int getPoints() {
        return points;
    }
}
