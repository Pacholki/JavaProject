package com.pacholki.loader;

import java.io.IOException;

import com.pacholki.controller.MainController;
import com.pacholki.entity.Competition;
import com.pacholki.entity.League;
import com.pacholki.entity.Season;

public class CompetitionDataGetter extends VisibleDataGetter {
    
    private League league;
    private Season season;
    private Competition competition;

    public CompetitionDataGetter(Competition competition, boolean isAnUpdate) {
        this.league = competition.getLeague();
        this.season = competition.getSeason();
        this.entity = competition;
        this.competition = competition;
        this.isAnUpdate = isAnUpdate;
        this.message = "CompetitionOverview";
        this.verbose = 1;
    }

    public CompetitionDataGetter(Competition competition) {
        this(competition, false);
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
            DownloadTimer downloadTimer = new DownloadTimer(10, process);
            downloadTimer.start();
            exitCode = process.waitFor();
            System.out.println(exitCode);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return exitCode;
    }

    @Override
    protected void addRequiredFiles() {
        requiredFiles.add(competition.getScheduleFilePath());
        requiredFiles.add(competition.getTeamsFilePath());
    }
    
    @Override
    protected void markUpdated() {
        competition.markUpdated();
    }

    @Override
    protected void saveCompetition() {
        ((MainController) competition.getController()).addToCompetitionList(competition);
    }
}