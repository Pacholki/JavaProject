package com.pacholki.getter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        System.out.println("Trying to download data for:\t" + league.getName() + "\t" + season.getLabel());

        getTeams();

        System.out.println("Download finished: \t" + league.getName() + "\t" + season.getLabel());

    }

    public void getTeams() {

        String scriptName = "get_league_teams.py";

        String scriptPath = SCRIPT_DIR + scriptName;
        ProcessBuilder processBuilder = new ProcessBuilder("python", scriptPath, league.getFBrefID(), season.getFBrefID());
        processBuilder.redirectErrorStream(false);

        try {
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            System.out.println("Script exited with code: " + exitCode);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
