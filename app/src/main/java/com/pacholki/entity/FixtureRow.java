package com.pacholki.entity;

public class FixtureRow {
    
    private String homeName;
    private int homeScore;
    private int awayScore;
    private String awayName;

    public FixtureRow(Game game) {
        this.homeName = game.getHomeTeamName();
        this.awayName = game.getAwayTeamName();
        this.homeScore = game.getHomeScore();
        this.awayScore = game.getAwayScore();
    }

    // ---------------------------------------------

    public String getHomeName() {
        return homeName;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public String getAwayName() {
        return awayName;
    }

    // ---------------------------------------------

    public String toString() {
        return homeName + " " + homeScore + " - " + awayScore + " " + awayName;
    }
}
