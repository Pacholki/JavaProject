package com.pacholki.getter;

import java.io.IOException;

import com.pacholki.entity.Competition;
import com.pacholki.entity.League;
import com.pacholki.entity.Season;

import javafx.application.Platform;

public class CompetitionDataGetter extends DataGetter {
    
    private League league;
    private Season season;
    private Competition competition;
    private Runnable onDataDownloadedCallback;

    public CompetitionDataGetter(Competition competition) {
        this.league = competition.getLeague();
        this.season = competition.getSeason();
        this.competition = competition;
    }

    public void setOnDataDownloaded(Runnable onDataDownloadedCallback) {
        this.onDataDownloadedCallback = onDataDownloadedCallback;
    }

    @Override
    public void run() {
        run(1);
    }

    public void run(int verbose) {
        downloadsStarted += 1;
        int id = downloadsStarted;

        if (verbose > 1) {
            System.out.println(id + ". -----\nTrying to download data for:\n" + league.getName() + "\t" + season.getLabel() + "\n-----");
        }

        int exitCode = getTeams();
        downloadsFinished += 1;
        int downloadsActive = downloadsStarted - downloadsFinished;

        if (exitCode == 0 & verbose > 0) {
            System.out.println(id + ". -----\nDownload successful: \n" + league.getName() + "\t" + season.getLabel() + "\nActive downloads: " + downloadsActive + "\n-----");
        } else if (verbose > 0) {
            System.out.println(id + ". -----\nFailed to download: \n" + league.getName() + "\t" + season.getLabel() + "\nActive downloads: " + downloadsActive + "\n-----");
        }

        competition.prepareData();

        if (onDataDownloadedCallback != null & downloadsActive == 0) {
            Platform.runLater(onDataDownloadedCallback);
        }
    }

    public int getTeams() {

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
