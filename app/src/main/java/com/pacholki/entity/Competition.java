package com.pacholki.entity;

import com.pacholki.controller.MainController;
import com.pacholki.getter.CompetitionDataGetter;

public class Competition {
    
    private static final String DATA_DIR = "src/main/resources/com/pacholki/data/leagues/";

    private League league;
    private Season season;
    private String compDir;
    @SuppressWarnings("unused")
    private String compTeamsFilePath;

    private MainController controller;

    public Competition(League league, Season season, MainController controller) {
        this.league = league;
        this.season = season;
        this.controller = controller;
        if (isValid())  {
            prepPaths();
            getData();
        }
    }

    private void prepPaths() {
        compDir = DATA_DIR + league.getName() + "/" + season.getFBrefID() + "/";
        compTeamsFilePath = compDir + "teams.json";
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

    public void getData() {
        CompetitionDataGetter getter = new CompetitionDataGetter(this);
        getter.setOnDataDownloaded(() -> controller.hello());
        getter.start();
    }

    public boolean isValid() {
        return (league != null & season != null);
    }

    public String toString() {
        if (! isValid())    return "Null values!!!";
        return league.toString() + "\t" + season.toString();
    }
}
