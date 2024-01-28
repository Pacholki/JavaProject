package com.pacholki.entity;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pacholki.controller.MainController;
import com.pacholki.loader.CompetitionDataGetter;
import com.pacholki.loader.PlayerDataGetter;

public class Competition extends Entity {
    
    private static final String LEAGUES_DIR = DATA_DIR + "leagues/";
    private static final String FXML_PATH = FXML_DIR + "competition.fxml";

    private String compDir;
    private String teamsFilePath;
    private String scheduleFilePath;
    private String playersFilePath;

    private League league;
    private Season season;
    private List<Team> teams;
    private List<Game> schedule;
    private List<Player> players;

    private int playedGameweeks;
    private int totalGameweeks;
    private boolean playerDataReady;

    public Competition(League league, Season season, MainController controller) {
        this.league = league;
        this.season = season;
        this.controller = controller;
        this.playerDataReady = false;
        this.playedGameweeks = 0;
        this.totalGameweeks = 0;
        if (isValid())  {
            prepPaths();
            getData();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            getPlayersData();
        }
    }

    private void prepPaths() {
        compDir = LEAGUES_DIR + league.getName() + "/" + season.getFBrefID() + "/";
        teamsFilePath = compDir + "teams.json";
        scheduleFilePath = compDir + "schedule.json";
        playersFilePath = compDir + "players.json";
    }
    // ---------------------------------------------

    private void getData() {
        getter = new CompetitionDataGetter(this);
        getter.start();
    }

    private void getPlayersData() {
        PlayerDataGetter playerGetter = new PlayerDataGetter(this);
        playerGetter.start();
    }


    @Override
    public void prepareData() {
        readTeams();
        readSchedule();
        prepareSchedule();
        prepareTable();
        preparePlayers();
    }

    public void preparePlayerData(){
        readPlayers();
        preparePlayers();
    }

    // ---------------------------------------------

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

    private void readPlayers() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            players = mapper.readValue(new File(playersFilePath), new TypeReference<List<Player>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void prepareSchedule() {
        for (Game game : schedule) {
            game.setCompetition(this);
            game.prepareData();
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

    private void preparePlayers() {
        if (! playerDataReady) {
            playerDataReady = true;
            return;
        }

        for (Player player : players) {
            player.setCompetition(this);
            player.prepareData();
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

    public void setPlayedGameweeks(int gameweek) {
        playedGameweeks = gameweek;
    }

    public void setTotalGameweeks(int gameweek) {
        totalGameweeks = gameweek;
    }

    @Override
    public String getFXMLPath() {return FXML_PATH;}
    public String getDATA_DIR() {return DATA_DIR;}

    public String getTeamsFilePath() {return teamsFilePath;}
    public String getScheduleFilePath() {return scheduleFilePath;}
    public String getPlayersFilePath() {return playersFilePath;}

    public League getLeague() {return league;}
    public Season getSeason() {return season;}
    public List<Team> getTeams() {return teams;}
    public List<Game> getSchedule() {return schedule;}
    public String getCompDir() {return compDir;} 
    public int getPlayedGameweeks() {return playedGameweeks;}
    public int getTotalGameweeks() {return totalGameweeks;}

    public List<Player> getPlayers() {return players;}

    // ---------------------------------------------

    public String toString() {
        if (! isValid())    return "Null values!!!";
        return league.toString() + "\t" + season.toString();
    }
}
