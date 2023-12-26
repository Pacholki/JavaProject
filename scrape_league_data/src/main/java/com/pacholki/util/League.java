package com.pacholki.util;

import com.fasterxml.jackson.annotation.JsonProperty;

public class League {
    
    private String name;
    @JsonProperty("FBrefID")
    private String FBrefID;

    // ---------------------------------------------

    public String getFBrefID() {
        return FBrefID;
    }

    public String getName() {
        return name;
    }

    // ---------------------------------------------

    public void setName(String name) {
        this.name = name;
    }

    public void setFBrefID(String FBrefID) {
        this.FBrefID = FBrefID;
    }

    // ---------------------------------------------

    @Override
    public String toString() {
        return "League{" +
                "name='" + name + "\', " +
                "FBrefID='" + FBrefID +"\'" +
                '}';
    }
}
