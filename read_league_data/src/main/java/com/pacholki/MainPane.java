package com.pacholki;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pacholki.util.League;
import com.pacholki.util.LeagueDataGetter;
import com.pacholki.util.Season;

public class MainPane {
    
    private final String DATAPATH = "src/main/resources/com/pacholki/data/";
    private final String LEAGUENAMESFILEPATH = DATAPATH + "leagues.json";
    private final String SEASONNAMESFILEPATH = DATAPATH + "seasons.json";

    private List<Season> seasons;
    private List<League> leagues;

    public void readLeagues() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<League> leagues = mapper.readValue(new File(LEAGUENAMESFILEPATH), new TypeReference<List<League>>() {});
            this.leagues = leagues;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readSeasons() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Season> seasons = mapper.readValue(new File(SEASONNAMESFILEPATH), new TypeReference<List<Season>>() {});
            for (Season season : seasons) {
                season.generateLabel();
            }
            this.seasons = seasons;
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void getData() {

        LeagueDataGetter getter = new LeagueDataGetter(leagues.get(0), seasons.get(0));
        getter.run();

        // for (League league : leagues) {
        //     for (Season season : seasons) {

        //         LeagueDataGetter getter = new LeagueDataGetter(league, season);
        //         getter.start();
        //         try {
        //             Thread.sleep(1000);
        //         } catch (InterruptedException e) {
        //             e.printStackTrace();
        //         }
        //     }
        // }
    }
}
