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


    @Override
    public void prepareData() {

    }

    @Override
    public String getFXMLPath() {
        return null;
    }
}
