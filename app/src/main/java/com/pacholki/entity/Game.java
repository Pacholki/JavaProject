package com.pacholki.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Game {
    @JsonProperty("week")
    private int gameweek;
    private String day;
    private String date;
    private String time;
    @JsonProperty("home_team")
    private String homeTeam;
    @JsonProperty("away_team")
    private String awayTeam;
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
    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }
    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
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
    public String getHomeTeam() {
        return homeTeam;
    }
    public String getAwayTeam() {
        return awayTeam;
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

    // ---------------------------------------------

    @Override
    public String toString() {
        return "gameweek " + gameweek + " " + homeTeam + " " + score + " " + awayTeam;
    }
}
