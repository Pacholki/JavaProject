package com.pacholki.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeagueDataGetter extends DataGetter {

    private League league;
    private Season season;

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

        String pythonScript = SCRIPT_PATH + scriptName;
        ProcessBuilder processBuilder = new ProcessBuilder("python", pythonScript, league.getFBrefID(), season.getFBrefID());
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
