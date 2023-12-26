package com.pacholki.pane;

public class Competition {
    
    private static final String DATA_DIR = "src/main/resources/com/pacholki/data/";

    private League league;
    private Season season;
    private String compDir;

    public Competition() {

    }

    public Competition(League league, Season season) {
        this.league = league;
        this.season = season;
        if (isValid())  makeCompDir();
    }

    private void makeCompDir() {
        compDir = DATA_DIR + league.getName() + "/" + season.getFBrefID();
    }

    public League getLeague() {
        return league;
    }

    public Season getSeason() {
        return season;
    }

    public String getCompDir() {
        return compDir;
    } 

    public boolean isValid() {
        return (league != null & season != null);
    }

    public String toString() {
        if (! isValid())    return "Null values!!!";
        return league.toString() + "\t" + season.toString();
    }
}
