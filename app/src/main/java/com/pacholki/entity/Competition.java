package com.pacholki.entity;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pacholki.controller.MainController;
import com.pacholki.getter.CompetitionDataGetter;
import com.pacholki.util.Tools;

public class Competition {
    
    private static final String DATA_DIR = "src/main/resources/com/pacholki/data/leagues/";

    private League league;
    private Season season;
    private List<Team> teams;
    private List<Game> schedule;

    private String compDir;
    private String teamsFilePath;
    private String scheduleFilePath;

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
        teamsFilePath = compDir + "teams.json";
        scheduleFilePath = compDir + "schedule.json";
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

    public List<Team> getTeams() {
        return teams;
    }

    private void getData() {
        CompetitionDataGetter getter = new CompetitionDataGetter(this);
        getter.setOnDataDownloaded(() -> controller.updateMainPane());
        getter.start();
    }

    public void prepareData() {
        readTeams();
        readSchedule();
    }

    private void readTeams() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            teams = mapper.readValue(new File(teamsFilePath), new TypeReference<List<Team>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readSchedule() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            schedule = mapper.readValue(new File(scheduleFilePath), new TypeReference<List<Game>>() {});

            Tools.display(schedule);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isValid() {
        return (league != null & season != null);
    }

    public String toString() {
        if (! isValid())    return "Null values!!!";
        return league.toString() + "\t" + season.toString();
    }
}
