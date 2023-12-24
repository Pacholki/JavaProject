package com.pacholki.pane.league;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Season {

    private String label;
    @JsonProperty("season")
    private String id;

    // ---------------------------------------------

    public String getLabel() {
        return label;
    }
    public String getID() {
        return id;
    }

    // ---------------------------------------------

    public void generateLabel() {
        this.label = "20" + id.substring(0,2) + " / 20" + id.substring(2,4);
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setID(String id) {
        this.id = id;
    }
}

