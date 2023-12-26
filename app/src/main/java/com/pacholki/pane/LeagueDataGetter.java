package com.pacholki.pane;

public class LeagueDataGetter extends Thread {
    
    League league;
    Season season;

    public LeagueDataGetter(League league, Season season) {
        this.league = league;
        this.season = season;
    }

    @Override
    public void run() {
        System.out.println("Trying to download data for:\nLeague: " + league.getName() + "\nSeason: " + season.getLabel());
    }
}
