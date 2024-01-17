package com.pacholki.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Player extends Entity {

    @JsonProperty("league")
    private String league;
    @JsonProperty("season")
    private String season;
    @JsonProperty("team")
    private String team;
    @JsonProperty("player")
    private String playerName;
    @JsonProperty("nation")
    private String nation;
    @JsonProperty("pos")
    private String position;
    @JsonProperty("age")
    private String age;
    @JsonProperty("born")
    private int birthYear;
    @JsonProperty("Playing TimeMP")
    private int playingTimeMP;
    @JsonProperty("Playing TimeStarts")
    private int playingTimeStarts;
    @JsonProperty("Playing TimeMin")
    private int playingTimeMin;
    @JsonProperty("Playing Time90s")
    private double playingTime90s;
    @JsonProperty("PerformanceGls")
    private int performanceGoals;
    @JsonProperty("PerformanceAst")
    private int performanceAssists;
    @JsonProperty("PerformanceG+A")
    private int performanceGoalsAndAssists;
    @JsonProperty("PerformanceG-PK")
    private int performanceGoalsPK;
    @JsonProperty("PerformancePK")
    private int performancePenaltyKicks;
    @JsonProperty("PerformancePKatt")
    private int performancePenaltyKicksAttempts;
    @JsonProperty("PerformanceCrdY")
    private int performanceYellowCards;
    @JsonProperty("PerformanceCrdR")
    private int performanceRedCards;
    @JsonProperty("ExpectedxG")
    private double expectedxG;
    @JsonProperty("ExpectednpxG")
    private double expectednpxG;
    @JsonProperty("ExpectedxAG")
    private double expectedxAG;
    @JsonProperty("ExpectednpxG+xAG")
    private double expectednpxGplusxAG;
    @JsonProperty("ProgressionPrgC")
    private int progressionPrgC;
    @JsonProperty("ProgressionPrgP")
    private int progressionPrgP;
    @JsonProperty("ProgressionPrgR")
    private int progressionPrgR;
    @JsonProperty("Per 90 MinutesGls")
    private double per90MinutesGoals;
    @JsonProperty("Per 90 MinutesAst")
    private double per90MinutesAssists;
    @JsonProperty("Per 90 MinutesG+A")
    private double per90MinutesGoalsAndAssists;
    @JsonProperty("Per 90 MinutesG-PK")
    private double per90MinutesGoalsPK;
    @JsonProperty("Per 90 MinutesG+A-PK")
    private double per90MinutesGoalsAndAssistsPK;
    @JsonProperty("Per 90 MinutesxG")
    private double per90MinutesxG;
    @JsonProperty("Per 90 MinutesxAG")
    private double per90MinutesxAG;
    @JsonProperty("Per 90 MinutesxG+xAG")
    private double per90MinutesxGplusxAG;
    @JsonProperty("Per 90 MinutesnpxG")
    private double per90MinutesnpxG;
    @JsonProperty("Per 90 MinutesnpxG+xAG")
    private double per90MinutesnpxGplusxAG;

    // ---------------------------------------------

    public String getLeague() {
        return league;
    }

    public String getSeason() {
        return season;
    }

    public String getTeam() {
        return team;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getNation() {
        return nation;
    }

    public String getPosition() {
        return position;
    }

    public String getAge() {
        return age;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getPlayingTimeMP() {
        return playingTimeMP;
    }

    public int getPlayingTimeStarts() {
        return playingTimeStarts;
    }

    public int getPlayingTimeMin() {
        return playingTimeMin;
    }

    public double getPlayingTime90s() {
        return playingTime90s;
    }

    public int getPerformanceGoals() {
        return performanceGoals;
    }

    public int getPerformanceAssists() {
        return performanceAssists;
    }

    public int getPerformanceGoalsAndAssists() {
        return performanceGoalsAndAssists;
    }

    public int getPerformanceGoalsPK() {
        return performanceGoalsPK;
    }

    public int getPerformancePenaltyKicks() {
        return performancePenaltyKicks;
    }

    public int getPerformancePenaltyKicksAttempts() {
        return performancePenaltyKicksAttempts;
    }

    public int getPerformanceYellowCards() {
        return performanceYellowCards;
    }

    public int getPerformanceRedCards() {
        return performanceRedCards;
    }

    public double getExpectedxG() {
        return expectedxG;
    }

    public double getExpectednpxG() {
        return expectednpxG;
    }

    public double getExpectedxAG() {
        return expectedxAG;
    }

    public double getExpectednpxGplusxAG() {
        return expectednpxGplusxAG;
    }

    public int getProgressionPrgC() {
        return progressionPrgC;
    }

    public int getProgressionPrgP() {
        return progressionPrgP;
    }

    public int getProgressionPrgR() {
        return progressionPrgR;
    }

    public double getPer90MinutesGoals() {
        return per90MinutesGoals;
    }

    public double getPer90MinutesAssists() {
        return per90MinutesAssists;
    }

    public double getPer90MinutesGoalsAndAssists() {
        return per90MinutesGoalsAndAssists;
    }

    public double getPer90MinutesGoalsPK() {
        return per90MinutesGoalsPK;
    }

    public double getPer90MinutesGoalsAndAssistsPK() {
        return per90MinutesGoalsAndAssistsPK;
    }

    public double getPer90MinutesxG() {
        return per90MinutesxG;
    }

    public double getPer90MinutesxAG() {
        return per90MinutesxAG;
    }

    public double getPer90MinutesxGplusxAG() {
        return per90MinutesxGplusxAG;
    }

    public double getPer90MinutesnpxG() {
        return per90MinutesnpxG;
    }

    public double getPer90MinutesnpxGplusxAG() {
        return per90MinutesnpxGplusxAG;
    }

    // ---------------------------------------------

    public void setLeague(String league) {
        this.league = league;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public void setPlayingTimeMP(int playingTimeMP) {
        this.playingTimeMP = playingTimeMP;
    }

    public void setPlayingTimeStarts(int playingTimeStarts) {
        this.playingTimeStarts = playingTimeStarts;
    }

    public void setPlayingTimeMin(int playingTimeMin) {
        this.playingTimeMin = playingTimeMin;
    }

    public void setPlayingTime90s(double playingTime90s) {
        this.playingTime90s = playingTime90s;
    }

    public void setPerformanceGoals(int performanceGoals) {
        this.performanceGoals = performanceGoals;
    }

    public void setPerformanceAssists(int performanceAssists) {
        this.performanceAssists = performanceAssists;
    }

    public void setPerformanceGoalsAndAssists(int performanceGoalsAndAssists) {
        this.performanceGoalsAndAssists = performanceGoalsAndAssists;
    }

    public void setPerformanceGoalsPK(int performanceGoalsPK) {
        this.performanceGoalsPK = performanceGoalsPK;
    }

    public void setPerformancePenaltyKicks(int performancePenaltyKicks) {
        this.performancePenaltyKicks = performancePenaltyKicks;
    }

    public void setPerformancePenaltyKicksAttempts(int performancePenaltyKicksAttempts) {
        this.performancePenaltyKicksAttempts = performancePenaltyKicksAttempts;
    }

    public void setPerformanceYellowCards(int performanceYellowCards) {
        this.performanceYellowCards = performanceYellowCards;
    }

    public void setPerformanceRedCards(int performanceRedCards) {
        this.performanceRedCards = performanceRedCards;
    }

    public void setExpectedxG(double expectedxG) {
        this.expectedxG = expectedxG;
    }

    public void setExpectednpxG(double expectednpxG) {
        this.expectednpxG = expectednpxG;
    }

    public void setExpectedxAG(double expectedxAG) {
        this.expectedxAG = expectedxAG;
    }

    public void setExpectednpxGplusxAG(double expectednpxGplusxAG) {
        this.expectednpxGplusxAG = expectednpxGplusxAG;
    }

    public void setProgressionPrgC(int progressionPrgC) {
        this.progressionPrgC = progressionPrgC;
    }

    public void setProgressionPrgP(int progressionPrgP) {
        this.progressionPrgP = progressionPrgP;
    }

    public void setProgressionPrgR(int progressionPrgR) {
        this.progressionPrgR = progressionPrgR;
    }

    public void setPer90MinutesGoals(double per90MinutesGoals) {
        this.per90MinutesGoals = per90MinutesGoals;
    }

    public void setPer90MinutesAssists(double per90MinutesAssists) {
        this.per90MinutesAssists = per90MinutesAssists;
    }

    public void setPer90MinutesGoalsAndAssists(double per90MinutesGoalsAndAssists) {
        this.per90MinutesGoalsAndAssists = per90MinutesGoalsAndAssists;
    }

    public void setPer90MinutesGoalsPK(double per90MinutesGoalsPK) {
        this.per90MinutesGoalsPK = per90MinutesGoalsPK;
    }

    public void setPer90MinutesGoalsAndAssistsPK(double per90MinutesGoalsAndAssistsPK) {
        this.per90MinutesGoalsAndAssistsPK = per90MinutesGoalsAndAssistsPK;
    }

    public void setPer90MinutesxG(double per90MinutesxG) {
        this.per90MinutesxG = per90MinutesxG;
    }

    public void setPer90MinutesxAG(double per90MinutesxAG) {
        this.per90MinutesxAG = per90MinutesxAG;
    }

    public void setPer90MinutesxGplusxAG(double per90MinutesxGplusxAG) {
        this.per90MinutesxGplusxAG = per90MinutesxGplusxAG;
    }

    public void setPer90MinutesnpxG(double per90MinutesnpxG) {
        this.per90MinutesnpxG = per90MinutesnpxG;
    }

    public void setPer90MinutesnpxGplusxAG(double per90MinutesnpxGplusxAG) {
        this.per90MinutesnpxGplusxAG = per90MinutesnpxGplusxAG;
    }

    // ---------------------------------------------

    @Override
    public void prepareData() {

    }

    @Override
    public String getFXMLPath() {
        return null;
    }

    @Override
    public String toString() {
        return "Player: " + team + " " + playerName + " " + nation;
    }
}
