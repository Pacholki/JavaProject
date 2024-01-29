package com.pacholki.entity;

import java.util.List;

public class StatsTableRow {

    public static final List<String> colNames = List.of("Name", "Position", "Age", "Matches Played", "First 11", "Minutes Played", "Goals", "Assists", "Yellow Cards", "Red Cards");
    private String name;
    private String position;
    private int age;
    private int matchesPlayed;
    private int first11;
    private int playTime;
    private int goals;
    private int assists;
    private int yellowCards;
    private int redCards;

    public StatsTableRow(Player player) {
        this.name = player.getPlayerName();
        this.position = player.getPrimaryPosition();;
        this.age = player.getPlayerAgeInYears();
        this.matchesPlayed = player.getPlayingTimeMP();
        this.first11 = player.getPlayingTimeStarts();
        this.playTime = player.getPlayingTimeMin();
        this.goals = player.getPerformanceGoals();
        this.assists = player.getPerformanceAssists();
        this.yellowCards = player.getPerformanceYellowCards();
        this.redCards = player.getPerformanceRedCards();
    }

    //---------------------------------------------------------
    public String getName() {return name;}
    public String getPosition() {return position;}
    public int getAge() {return age;}
    public int getMatchesPlayed() {return matchesPlayed;}
    public int getFirst11() {return first11;}
    public int getPlayTime() {return playTime;}
    public int getGoals() {return goals;}
    public int getAssists() {return assists;}
    public int getYellowCards() {return yellowCards;}
    public int getRedCards() {return redCards;}

}
