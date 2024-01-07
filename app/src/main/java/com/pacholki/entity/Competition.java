package com.pacholki.entity;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pacholki.controller.MainController;
import com.pacholki.changer.CompetitionDataGetter;

public class Competition extends Entity {
    
    private static final String DATA_DIR = "src/main/resources/com/pacholki/data/leagues/";

    private League league;
    private Season season;
    private List<Team> teams;
    private List<Game> schedule;

    private String compDir;
    private String teamsFilePath;
    private String scheduleFilePath;

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
        fxmlPath = "/com/pacholki/fxml/league.fxml";

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
        getter = new CompetitionDataGetter(this);
        getter.start();
    }

    @Override
    public void prepareData() {
        readTeams();
        readSchedule();
        prepareSchedule();
        prepareTable();
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void prepareSchedule() {
        List <Game> gamesToBeRemoved = new ArrayList<>();
        for (Game game : schedule) {
            if(game.getGameweek() == null) {
                gamesToBeRemoved.add(game);
                continue;
            }
            game.setCompetition(this);
            game.prepareData();
        }

        for (Game game : gamesToBeRemoved) {
            schedule.remove(game);
        }

        schedule = schedule.stream()
                .sorted(Comparator.comparing(Game::getGameweek))
                .collect(Collectors.toList());

    }

    public void prepareTable() {
        for (Game game : schedule) {
            game.record();
        }
    }

    public boolean isValid() {
        return (league != null & season != null);
    }

    public Team getTeamByName(String name) {

        for (Team team : teams) {
            if (team.getName().equals(name))    return team;
        }

        return null;
    }

    public String toString() {
        if (! isValid())    return "Null values!!!";
        return league.toString() + "\t" + season.toString();
    }
}
