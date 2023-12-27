package com.pacholki.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Team {
    
    @JsonProperty("team")
    private String name;

    // ---------------------------------------------

    public String getName() {
        return name;
    }

    // ---------------------------------------------

    public void setName(String name) {
        this.name = name;
    }

    // ---------------------------------------------

    public String toString() {
        return name;
    }
}
