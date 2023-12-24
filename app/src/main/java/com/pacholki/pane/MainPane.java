package com.pacholki.pane;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pacholki.pane.league.League;
import com.pacholki.pane.league.Season;

import io.github.palexdev.materialfx.controls.MFXButton;

public class MainPane {

    private final String DATAPATH = "src/main/resources/com/pacholki/data/";
    private final String LEAGUENAMESFILEPATH = DATAPATH + "leagues.json";
    private final String SEASONNAMESFILEPATH = DATAPATH + "seasons.json";

    private List<League> leagues;
    private List<Season> seasons;
    
    private League currentLeagueName;
    private Season currentSeason;

    public MainPane() {
    }

    public MainPane(League currentLeagueName, Season currentSeason) {
        this.currentLeagueName = currentLeagueName;
        this.currentSeason = currentSeason;
    }

    public void readSeasons() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Season> seasons = mapper.readValue(new File(SEASONNAMESFILEPATH), new TypeReference<List<Season>>() {});
            this.seasons = seasons;
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void readLeagues() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<League> leagues = mapper.readValue(new File(LEAGUENAMESFILEPATH), new TypeReference<List<League>>() {});
            this.leagues = leagues;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<MFXButton> generateSeasonButtons() {

        List<MFXButton> seasonButtons = new ArrayList<>();

        for (Season season : seasons) {
            MFXButton button = new MFXButton(season.getID());
            button.setOnAction(e -> changeSeason(season));
            seasonButtons.add(button);
        }

        return seasonButtons;
    }

    public void changeSeason(Season season) {
        System.out.println("Changing season to " + season.getID());
    }

    public List<MFXButton> generateLeagueButtons() {

        // ObjectMapper = new ObjectMapper();

        List<MFXButton> leagueButtons = null;
        return leagueButtons;
    }


}
