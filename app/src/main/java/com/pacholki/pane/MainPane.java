package com.pacholki.pane;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pacholki.controller.MainController;
import com.pacholki.entity.Competition;
import com.pacholki.entity.League;
import com.pacholki.entity.Season;
import com.pacholki.entity.Team;

public class MainPane extends MyPane {

    private final String DATA_DIR = "src/main/resources/com/pacholki/data/";
    private final String LEAGUENAMESFILEPATH = DATA_DIR + "leagues.json";
    private final String SEASONNAMESFILEPATH = DATA_DIR + "seasons.json";
    private MainController controller;

    private List<League> leagues;
    private List<Season> seasons;
    private List<Competition> competitions;

    public MainPane(MainController controller) {
        this.controller = controller;
        readLeagues();
        readSeasons();
        competitions = new ArrayList<>();
    }
        
    public void loadFirstSeason() {
        System.out.println("siema");
        changeCompetition(leagues.get(0), seasons.get(0));
    }

    public void readSeasons() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Season> seasons = mapper.readValue(new File(SEASONNAMESFILEPATH), new TypeReference<List<Season>>() {
            });
            for (Season season : seasons) {
                season.generateLabel();
            }
            this.seasons = seasons;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readLeagues() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<League> leagues = mapper.readValue(new File(LEAGUENAMESFILEPATH), new TypeReference<List<League>>() {
            });
            this.leagues = leagues;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean changeCompetition(League league) {
        if (league.equals(currentCompetition.getLeague()))
            return false;
        return changeCompetition(league, currentCompetition.getSeason());
    }

    public boolean changeCompetition(Season season) {
        if (season.equals(currentCompetition.getSeason()))
            return false;
        return changeCompetition(currentCompetition.getLeague(), season);
    }

    private boolean changeCompetition(League league, Season season) {

        System.out.println("changing competition");
        boolean competitionFound = false;
        for (Competition competition : competitions) {
            if (competition.getLeague().equals(league) & competition.getSeason().equals(season)) {
                currentCompetition = competition;
                competitionFound = true;
                currentCompetition.setMe();
            }
        }

        if (!competitionFound) {
            System.out.println("not found");
            Competition competition = new Competition(league, season, controller);
            if (competitions.size() == 0) {
                currentCompetition = competition;
            }
        }

        return true;
    }

    public void handleCompetitionUpdate() {

        if (! currentCompetition.isActive())    return;
        if (currentCompetition.wasUpdated())    return;

        new Competition(currentCompetition.getLeague(), currentCompetition.getSeason(), controller, true);
    }

    public List<League> getLeagues() {
        return leagues;
    }

    public List<Season> getSeasons() {
        return seasons;
    }

    public League getCurrentLeague() {
        return currentCompetition.getLeague();
    }

    public Season getCurrentSeason() {
        return currentCompetition.getSeason();
    }

    public void setCurrentTeam(Team team) {
        currentTeam = team;
    }

    public void setCurrentCompetition(Competition competition) {
        currentCompetition = competition;
    }

    public void addCompetition(Competition competition) {
        competitions.add(competition);
    }

    public void tidyCompetitionList(Competition newCompetition) {
        List<Competition> deprecatedCompetitions = new ArrayList<>();
        for (Competition competition : competitions) {
            if (competition.getLeague().equals(newCompetition.getLeague()) & 
                competition.getSeason().equals(newCompetition.getSeason())) {
                    deprecatedCompetitions.add(competition);
                }
        }
        competitions.removeAll(deprecatedCompetitions);
    }
}
