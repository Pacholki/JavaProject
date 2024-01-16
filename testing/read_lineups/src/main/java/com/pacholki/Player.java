package com.pacholki;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Player {
    private int jersey_number;
    @JsonProperty("player")
    private String name;
    private String team;
    private boolean is_starter;
    private String position;
    private int minutes_played;

    public int getJersey_number() {
        return jersey_number;
    }
    public void setJersey_number(int jersey_number) {
        this.jersey_number = jersey_number;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTeam() {
        return team;
    }
    public void setTeam(String team) {
        this.team = team;
    }
    public boolean isIs_starter() {
        return is_starter;
    }
    public void setIs_starter(boolean is_starter) {
        this.is_starter = is_starter;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public int getMinutes_played() {
        return minutes_played;
    }
    public void setMinutes_played(int minutes_played) {
        this.minutes_played = minutes_played;
    }

    @Override
    public String toString() {
        return "Player{" +
                "jersey_number=" + jersey_number +
                ", name='" + name + '\'' +
                ", team='" + team + '\'' +
                ", is_starter=" + is_starter +
                ", position='" + position + '\'' +
                ", minutes_played=" + minutes_played +
                '}';
    }

}
