package com.pacholki.loader;

import com.pacholki.entity.Competition;
import com.pacholki.entity.League;
import com.pacholki.entity.Season;

import java.io.IOException;

public class PlayerDataGetter extends DataGetter {

    private League league;
    private Season season;

    public PlayerDataGetter(Competition competition) {
        this.league = competition.getLeague();
        this.season = competition.getSeason();
        this.entity = competition;
        this.message = "PlayerData";
        this.verbose = 1;
    }

    @Override
    public int getData() {

        String scriptName = "get_player_data.py";
        String scriptPath = SCRIPT_DIR + scriptName;

        ProcessBuilder processBuilder = new ProcessBuilder("python", scriptPath, league.getFBrefID(), season.getFBrefID());
        processBuilder.redirectErrorStream(false);

        int exitCode = 2;
        try {
            Process process = processBuilder.start();
            exitCode = process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return exitCode;
    }
    
    @Override
    protected void customDataAction() {
        Competition competition = (Competition) entity;
        competition.preparePlayerData();
    }
}
