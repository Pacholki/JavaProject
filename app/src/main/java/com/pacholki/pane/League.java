package com.pacholki.pane;

public class League {
    
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

    @Override
    public String toString() {
        return "League{" +
                "name='" + name + '\'' +
                '}';
    }
}
