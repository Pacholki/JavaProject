package com.pacholki.entity;

import java.util.List;

public class AdvancedTableRow {

    public static final List<String> colNames = List.of(
            "Name",
            "Position",
            "Expected Goals",
            "Expected NP xG",
            "Expected Assists",
            "Expected NP xG + xA",
            "Progression Prg C",
            "Progression Prg P",
            "Progression Prg R"
    );
    private String name;
    private String position;
    private double expectedxG;
    private double expectednpxG;
    private double expectedxAG;
    private double expectednpxGplusxAG;
    private int progressionPrgC;
    private int progressionPrgP;
    private int progressionPrgR;

    public AdvancedTableRow(Player player) {
        this.name = player.getPlayerName();
        this.position = player.getPrimaryPosition();
        this.expectedxG = player.getExpectedxG();
        this.expectednpxG = player.getExpectednpxG();
        this.expectedxAG = player.getExpectedxAG();
        this.expectednpxGplusxAG = player.getExpectednpxGplusxAG();
        this.progressionPrgC = player.getProgressionPrgC();
        this.progressionPrgP = player.getProgressionPrgP();
        this.progressionPrgR = player.getProgressionPrgR();
    }

    //------------------------------------------------------------------
    public String getName() { return name; }
    public String getPosition() { return position; }
    public double getExpectedxG() { return expectedxG; }
    public double getExpectednpxG() { return expectednpxG; }
    public double getExpectedxAG() { return expectedxAG; }
    public double getExpectednpxGplusxAG() { return expectednpxGplusxAG; }
    public int getProgressionPrgC() { return progressionPrgC; }
    public int getProgressionPrgP() { return progressionPrgP; }
    public int getProgressionPrgR() { return progressionPrgR; }

}
