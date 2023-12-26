package com.pacholki.getter;

import java.io.IOException;

import com.pacholki.pane.League;
import com.pacholki.pane.Season;

public class LeagueDataGetter extends DataGetter {
    
    League league;
    Season season;

    public LeagueDataGetter(League league, Season season) {
        this.league = league;
        this.season = season;
    }

    @Override
    public void run() {
        System.out.println("-----\nTrying to download data for:\n" + league.getName() + "\t" + season.getLabel() + "\n-----");

        int exitCode = getTeams();

        if (exitCode == 0) {
            System.out.println("-----\nDownload successful: \n" + league.getName() + "\t" + season.getLabel() + "\n-----");
        } else {
            System.out.println("-----\nFailed to download: \n" + league.getName() + "\t" + season.getLabel() + "\n-----");
        }
    }

    public int getTeams() {

        String scriptName = "get_league_teams.py";
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
