package com.pacholki.pane;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Season {

    private String label;
    @JsonProperty("season")
    private String FBrefID;

    // ---------------------------------------------

    public String getLabel() {
        return label;
    }
    public String getFBrefID() {
        return FBrefID;
    }

    // ---------------------------------------------

    public void generateLabel() {
        this.label = "20" + FBrefID.substring(0,2) + " / 20" + FBrefID.substring(2,4);
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setFBrefID(String FBrefID) {
        this.FBrefID = FBrefID;
    }

    public String toString() {
        return label;
    }
}

