package com.pacholki.entity;

public class FixtureRow {
    
    private String homeName;
    private String score;
    private String awayName;

    public FixtureRow(Game game) {
        this.homeName = game.getHomeTeamName();
        this.awayName = game.getAwayTeamName();
        this.score = game.getStringScore();
    }

    // ---------------------------------------------

    public String getHomeName() {
        return homeName;
    }

    public String getScore() { return score;}

    public String getAwayName() {
        return awayName;
    }

    // ---------------------------------------------

    public String toString() {
        return homeName + " " + score + " " + awayName;
    }
}
