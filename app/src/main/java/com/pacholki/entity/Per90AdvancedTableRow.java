package com.pacholki.entity;

import java.util.List;

public class Per90AdvancedTableRow {
    public static final List<String> colNames = List.of(
            "Name",
            "Position",
            "Per90 Gls",
            "Per90 Ast",
            "Per90 Gls and Ast",
            "Per90 Gls from PK",
            "Per90 Gls and Ast from PK",
            "Per90 xG",
            "Per90 xA",
            "Per90 xG + xA",
            "Per90 NP xG",
            "Per90 NP xG + xA"
    );
    private String name;
    private String position;
    private double per90MinutesGoals;
    private double per90MinutesAssists;
    private double per90MinutesGoalsAndAssists;
    private double per90MinutesGoalsPK;
    private double per90MinutesGoalsAndAssistsPK;
    private double per90MinutesxG;
    private double per90MinutesxAG;
    private double per90MinutesxGplusxAG;
    private double per90MinutesnpxG;
    private double per90MinutesnpxGplusxAG;

    public Per90AdvancedTableRow(Player player) {
        this.name = player.getPlayerName();
        this.position = player.getPrimaryPosition();
        this.per90MinutesGoals = player.getPer90MinutesGoals();
        this.per90MinutesAssists = player.getPer90MinutesAssists();
        this.per90MinutesGoalsAndAssists = player.getPer90MinutesGoalsAndAssists();
        this.per90MinutesGoalsPK = player.getPer90MinutesGoalsPK();
        this.per90MinutesGoalsAndAssistsPK = player.getPer90MinutesGoalsAndAssistsPK();
        this.per90MinutesxG = player.getPer90MinutesxG();
        this.per90MinutesxAG = player.getPer90MinutesxAG();
        this.per90MinutesxGplusxAG = player.getPer90MinutesxGplusxAG();
        this.per90MinutesnpxG = player.getPer90MinutesnpxG();
        this.per90MinutesnpxGplusxAG = player.getPer90MinutesnpxGplusxAG();
    }

    //------------------------------------------------------------------
    public String getName() { return name; }
    public String getPosition() { return position; }
    public double getPer90MinutesGoals() { return per90MinutesGoals; }
    public double getPer90MinutesAssists() { return per90MinutesAssists; }
    public double getPer90MinutesGoalsAndAssists() { return per90MinutesGoalsAndAssists; }
    public double getPer90MinutesGoalsPK() { return per90MinutesGoalsPK; }
    public double getPer90MinutesGoalsAndAssistsPK() { return per90MinutesGoalsAndAssistsPK; }
    public double getPer90MinutesxG() { return per90MinutesxG; }
    public double getPer90MinutesxAG() { return per90MinutesxAG; }
    public double getPer90MinutesxGplusxAG() { return per90MinutesxGplusxAG; }
    public double getPer90MinutesnpxG() { return per90MinutesnpxG; }
    public double getPer90MinutesnpxGplusxAG() { return per90MinutesnpxGplusxAG; }
}
