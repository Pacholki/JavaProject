package com.pacholki.controllers;

import io.github.palexdev.materialfx.controls.MFXButton;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class LeagueOverviewController {

    private String leagueName;
    private String currentSeason;

    @FXML
    private MFXButton chooseLeagueButton;
    @FXML
    private VBox leagueButtonContainer;
    @FXML
    private MFXButton chooseSeasonButton;
    @FXML
    private VBox seasonButtonContainer;

    @FXML
    private void handleChooseLeague() {

        boolean wasActive = leagueButtonContainer.getChildren().size() != 0;
        leagueButtonContainer.getChildren().clear();
        if (wasActive)  return;

        MFXButton premierLeagueButton = new MFXButton("Premier League");
        MFXButton laLigaButton = new MFXButton("La Liga");
        MFXButton ligueOneButton = new MFXButton("Ligue One");
        MFXButton serieAButton = new MFXButton("Serie A");
        MFXButton bundesligaButton = new MFXButton("Bundesliga");
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

    @FXML
    private void handleChooseSeason() {

        boolean wasActive = seasonButtonContainer.getChildren().size() != 0;
        seasonButtonContainer.getChildren().clear();
        if (wasActive)  return;

        Button season2324Button = new Button("2023 / 2024");
        Button season2223Button = new Button("2022 / 2023");
        Button season2122Button = new Button("2021 / 2022");
        Button season2021Button = new Button("2020 / 2021");
        Button season1920Button = new Button("2019 / 2020");
        season2324Button.setOnAction(e -> handleSeasonButtonClick("2023 / 2024"));
        season2223Button.setOnAction(e -> handleSeasonButtonClick("2022 / 2023"));
        season2122Button.setOnAction(e -> handleSeasonButtonClick("2021 / 2022"));
        season2021Button.setOnAction(e -> handleSeasonButtonClick("2020 / 2021"));
        season1920Button.setOnAction(e -> handleSeasonButtonClick("2019 / 2020"));
        seasonButtonContainer.getChildren().add(season2324Button);
        seasonButtonContainer.getChildren().add(season2223Button);
        seasonButtonContainer.getChildren().add(season2122Button);
        seasonButtonContainer.getChildren().add(season2021Button);
        seasonButtonContainer.getChildren().add(season1920Button);
    }

    private void handleLeagueButtonClick(String leagueName) {
        this.leagueName = leagueName;
        leagueButtonContainer.getChildren().clear();
        chooseLeagueButton.setText(leagueName);
    }

    private void handleSeasonButtonClick(String season) {
        this.currentSeason = season;
        seasonButtonContainer.getChildren().clear();
        chooseSeasonButton.setText(season);
    }

    public String getLeagueName() {
        return leagueName;
    }
    public String getCurrentSeason() {
        return currentSeason;
    }
}
