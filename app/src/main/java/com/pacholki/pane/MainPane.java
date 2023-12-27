package com.pacholki.pane;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pacholki.entity.Competition;
import com.pacholki.entity.League;
import com.pacholki.entity.Season;

public class MainPane {

    private final String DATA_DIR = "src/main/resources/com/pacholki/data/";
    private final String LEAGUENAMESFILEPATH = DATA_DIR + "leagues.json";
    private final String SEASONNAMESFILEPATH = DATA_DIR + "seasons.json";

    private List<League> leagues;
    private List<Season> seasons;
    private List<Competition> competitions;

    private Competition currentCompetition;

    public MainPane() {
        readLeagues();
        readSeasons();
        competitions = new ArrayList<>();
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

        boolean competitionFound = false;
        for (Competition competition : competitions) {
            if (competition.getLeague().equals(league) & competition.getSeason().equals(season)) {
                currentCompetition = competition;
                competitionFound = true;
            }
        }
        if (!competitionFound) {
            currentCompetition = new Competition(league, season);
            competitions.add(currentCompetition);
        }

        return true;
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
}
