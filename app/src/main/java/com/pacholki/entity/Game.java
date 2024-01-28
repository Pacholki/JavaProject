package com.pacholki.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.*;

public class Game extends Entity {

    private static final String FXML_PATH = DATA_DIR + "fxml/game.fxml";

    @JsonProperty("week")
    private int gameweek;
    private String day;
    private long date;
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
    public void setDate(long date) {
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

    @SuppressWarnings("unused")
    private void setRound(String round) {}

    // ---------------------------------------------

    public int getGameweek() {
        return gameweek;
    }
    public String getDay() {
        return day;
    }
    public long getDate() {
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

    public String getStringScore() {
        if(!hasBeenPlayed()){return getDaysUntilMatch();}
        return score;
    }
    private String getDaysUntilMatch() {
        Instant instant = Instant.ofEpochMilli(date);
        LocalDate matchDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate currentDate = LocalDate.now();

        Period period = Period.between(currentDate, matchDate);

        if (period.isZero()) {
            return "Today";
        } else if (period.isNegative()) {
            return "in the past";
        } else {
            StringBuilder result = new StringBuilder("in ");
            if (period.getYears() > 0) {
                result.append(period.getYears()).append(" years ");
            }
            if (period.getMonths() > 0) {
                result.append(period.getMonths()).append(" months ");
            }
            if (period.getDays() > 0) {
                result.append(period.getDays()).append(" days");
            }
            return result.toString().trim();
        }
    }

    // ---------------------------------------------

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    @Override
    public void prepareData() {
        setHomeTeam(competition.getTeamByName(homeTeamName));
        setAwayTeam(competition.getTeamByName(awayTeamName));
        prepareScore();
        updateGameweek();
    }

    private void prepareScore() {

        if (score == null) return;

        this.homeScore = Integer.parseInt(score.split("\u2013")[0]);
        this.awayScore = Integer.parseInt(score.split("\u2013")[1]);
    }

    private void updateGameweek() {
        competition.setTotalGameweeks(Math.max(competition.getTotalGameweeks(), gameweek));
        if(!hasBeenPlayed()) return;
        competition.setPlayedGameweeks(Math.max(competition.getPlayedGameweeks(), gameweek));
    }

    public void record() {
        
        try {
            if (! hasBeenPlayed()) {
                recordIfNotPlayed(homeTeam);
                recordIfNotPlayed(awayTeam);
                return;
            }

            homeTeam.setGoalsFor(gameweek, homeScore);
            homeTeam.setGoalsAgainst(gameweek, awayScore);
            awayTeam.setGoalsFor(gameweek, awayScore);
            awayTeam.setGoalsAgainst(gameweek, homeScore);

            if(homeScore > awayScore){
                handleWin(homeTeam);
                handleLoss(awayTeam);
            } else if (awayScore > homeScore) {
                handleWin(awayTeam);
                handleLoss(homeTeam);
            } else {
                handleDraw(homeTeam);
                handleDraw(awayTeam);
            }
            homeTeam.setGamesPlayed(gameweek, 1);
            awayTeam.setGamesPlayed(gameweek, 1);
        } catch (Exception e) {
            System.out.println(this);
        }
    }

    public void recordIfNotPlayed(Team team) {
        team.setGamesPlayed(gameweek, 0);
        team.setGamesWon(gameweek, 0);
        team.setGamesDrawn(gameweek, 0);
        team.setGamesLost(gameweek, 0);

        team.setGoalsFor(gameweek, 0);
        team.setGoalsAgainst(gameweek, 0);
        team.setPoints(gameweek, 0);
    }

    public void handleWin(Team team) {
        team.setGamesWon(gameweek, 1);
        team.setGamesLost(gameweek, 0);
        team.setGamesDrawn(gameweek, 0);
        team.setPoints(gameweek, 3);
    }
    public void handleDraw(Team team) {
        team.setGamesWon(gameweek, 0);
        team.setGamesLost(gameweek, 0);
        team.setGamesDrawn(gameweek, 1);
        team.setPoints(gameweek, 1);
    }
    public void handleLoss(Team team) {
        team.setGamesWon(gameweek, 0);
        team.setGamesLost(gameweek, 1);
        team.setGamesDrawn(gameweek, 0);
        team.setPoints(gameweek, 0);
    }

    public boolean hasBeenPlayed() {
        if (score == null)  return false;
        return true;
    }

    @Override
    public void setMe() {

    }

    @Override
    public String getFXMLPath() {
        return FXML_PATH;
    }

    // ---------------------------------------------

    @Override
    public String toString() {
        return "gameweek " + gameweek + " " + homeTeamName + " " + homeScore + "-" + awayScore + " " + awayTeamName;
    }
}
