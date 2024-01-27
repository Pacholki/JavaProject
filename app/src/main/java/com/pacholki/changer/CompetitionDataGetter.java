package com.pacholki.changer;

import java.io.IOException;

import com.pacholki.entity.Competition;
import com.pacholki.entity.League;
import com.pacholki.entity.Season;

public class CompetitionDataGetter extends VisibleDataGetter {
    
    private League league;
    private Season season;

    public CompetitionDataGetter(Competition competition) {
        this.league = competition.getLeague();
        this.season = competition.getSeason();
        this.entity = competition;
        this.message = "CompetitionOverview";
        this.verbose = 1;
    }

    @Override
    public int getData() {

        String scriptName = "get_competition_data.py";
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
}