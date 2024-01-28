package com.pacholki.loader;

import com.pacholki.entity.Competition;
import com.pacholki.entity.League;
import com.pacholki.entity.Season;

import java.io.IOException;

public class PlayerDataGetter extends DataGetter {

    private League league;
    private Season season;
    private Competition competition;

    public PlayerDataGetter(Competition competition, boolean isAnUpdate) {
        this.league = competition.getLeague();
        this.season = competition.getSeason();
        this.entity = competition;
        this.competition = competition;
        this.isAnUpdate = isAnUpdate;
        this.message = "PlayerData";
        this.verbose = 1;
    }

    public PlayerDataGetter(Competition competition) {
        this(competition, false);
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
        competition.preparePlayerData();
    }

    @Override
    protected void addRequiredFiles() {
        requiredFiles.add(competition.getPlayersFilePath());
    }

    @Override
    protected void markUpdated() {}
    @Override
    protected void showLoadScreen() {}
}
