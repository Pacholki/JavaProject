package com.pacholki.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class LeagueOverviewController2 {

    private String leagueName;

    @FXML
    private VBox leagueButtonContainer;
    @FXML
    private Button chooseLeague;

    @FXML
    private void handleSelectLeague() {
        System.out.println("Select button clicked!");

        boolean wasActive = leagueButtonContainer.getChildren().size() != 0;
        leagueButtonContainer.getChildren().clear();
        if (wasActive)  return;

        Button premierLeagueButton = new Button("Premier League");
        Button laLigaButton = new Button("La Liga");
        Button ligueOneButton = new Button("Ligue One");
        Button serieAButton = new Button("Serie A");
        Button bundesligaButton = new Button("Bundesliga");
        premierLeagueButton.setOnAction(e -> handleLeagueButtonClick("Premier League"));
        laLigaButton.setOnAction(e -> handleLeagueButtonClick("La Liga"));
        ligueOneButton.setOnAction(e -> handleLeagueButtonClick("Ligue One"));
        serieAButton.setOnAction(e -> handleLeagueButtonClick("Serie A"));
        bundesligaButton.setOnAction(e -> handleLeagueButtonClick("Bundesliga"));
        leagueButtonContainer.getChildren().add(premierLeagueButton);
        leagueButtonContainer.getChildren().add(laLigaButton);
        leagueButtonContainer.getChildren().add(ligueOneButton);
        leagueButtonContainer.getChildren().add(serieAButton);
        leagueButtonContainer.getChildren().add(bundesligaButton);
    }

    private void handleLeagueButtonClick(String leagueName) {
        this.leagueName = leagueName;
        System.out.println("You have chosen the league: " + leagueName);
        leagueButtonContainer.getChildren().clear();
        chooseLeague.setText(leagueName);
    }

    public String getLeagueName() {
        return leagueName;
    }
}
