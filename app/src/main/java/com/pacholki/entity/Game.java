package com.pacholki.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Game extends Entity {
    @JsonProperty("week")
    private int gameweek;
    private String day;
    private String date;
    private String time;
    @JsonProperty("home_team")
    private String homeTeamName;
    @JsonProperty("away_team")
    private String awayTeamName;
    private String score;
    @JsonProperty("home_xg")
    private double homeXG;
    @JsonProperty("away_xg")
    private double awayXG;
    private int attendance;
    private String venue;
    private String referee;
    @JsonProperty("match_report")
    private String matchReport;
    private String notes;
    @JsonProperty("game_id")
    private String gameID;

    private Competition competition;
    private Team homeTeam;
    private Team awayTeam;
    private int homeScore;
    private int awayScore;

    // ---------------------------------------------

    public void setGameweek(int gameweek) {
        this.gameweek = gameweek;
    }
    public void setDay(String day) {
        this.day = day;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public void setHomeTeamName(String homeTeam) {
        this.homeTeamName = homeTeam;
    }
    public void setAwayTeamName(String awayTeam) {
        this.awayTeamName = awayTeam;
    }
    public void setScore(String score) {
        this.score = score;
    }
    public void setHomeXG(double homeXG) {
        this.homeXG = homeXG;
    }
    public void setAwayXG(double awayXG) {
        this.awayXG = awayXG;
    }
    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }
    public void setVenue(String venue) {
        this.venue = venue;
    }
    public void setReferee(String referee) {
        this.referee = referee;
    }
    public void setMatchReport(String matchReport) {
        this.matchReport = matchReport;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public void setGameID(String gameID) {
        this.gameID = gameID;
    }

    private void setHomeTeam(Team team) {
        this.homeTeam = team;
    }

    private void setAwayTeam(Team team) {
        this.awayTeam = team;
    }

    private void prepareScore() {

        if (score == null) return;

        this.homeScore = Integer.parseInt(score.split("\u2013")[0]);
        this.awayScore = Integer.parseInt(score.split("\u2013")[1]);
    }

    // ---------------------------------------------

    public int getWeek() {
        return gameweek;
    }
    public String getDay() {
        return day;
    }
    public String getDate() {
        return date;
    }
    public String getTime() {
        return time;
    }
    public String getHomeTeamName() {
        return homeTeamName;
    }
    public String getAwayTeamName() {
        return awayTeamName;
    }
    public String getScore() {
        return score;
    }
    public double getHomeXG() {
        return homeXG;
    }
    public double getAwayXG() {
        return awayXG;
    }
    public int getAttendance() {
        return attendance;
    }
    public String getVenue() {
        return venue;
    }
    public String getReferee() {
        return referee;
    }
    public String getMatchReport() {
        return matchReport;
    }
    public String getNotes() {
        return notes;
    }
    public String gameID() {
        return gameID;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }
    public Team getAwayTeam() {
        return awayTeam;
    }
    public int getHomeScore() {
        return homeScore;
    }
    public int getAwayScore() {
        return awayScore;
    }

    // ---------------------------------------------

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    @Override
    public void prepareData() {
        setHomeTeam(competition.getTeamByName(getHomeTeamName()));
        setAwayTeam(competition.getTeamByName(getAwayTeamName()));
        prepareScore();
    }

    // ---------------------------------------------

    @Override
    public String toString() {
        return "gameweek " + gameweek + " " + homeTeamName + " " + homeScore + "-" + awayScore + " " + awayTeamName;
    }
}
