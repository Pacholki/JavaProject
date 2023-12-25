package com.pacholki.pane;

public class League {
    
    private String name;
    private String season;

    // ---------------------------------------------

    public String getName() {
        return name;
    }
    public String getSeason() {
        return season;
    }

    // ---------------------------------------------

    public void setName(String name) {
        this.name = name;
    }
    public void setSeason(String season) {
        this.season = season;
    }

    // ---------------------------------------------

    @Override
    public String toString() {
        return "League{" +
                "name='" + name + '\'' +
                ", season='" + season + '\'' +
                '}';
    }
}
