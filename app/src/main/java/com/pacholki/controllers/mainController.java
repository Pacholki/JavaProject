package com.pacholki.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.pacholki.Tools;
import com.pacholki.pane.MainPane;
import com.pacholki.pane.league.League;
import com.pacholki.pane.league.Season;

import io.github.palexdev.materialfx.controls.MFXButton;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

public class mainController implements Initializable {

    private MainPane mainPane;
    private String currentLeagueName;

    @FXML
    private MFXButton chooseLeagueButton;
    @FXML
    private VBox leagueButtonContainer;
    @FXML
    private MFXButton chooseSeasonButton;
    @FXML
    private VBox seasonButtonContainer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mainPane = new MainPane();
        mainPane.readSeasons();
        mainPane.readLeagues();
    }

    @FXML
    private void handleChooseLeague() {
        
        boolean wasActive = leagueButtonContainer.getChildren().size() != 0;
        leagueButtonContainer.getChildren().clear();
        if (wasActive)  return;

        leagueButtonContainer.getChildren().setAll(generateLeagueButtons());
    }

    @FXML
    private void handleChooseSeason() {

        boolean wasActive = seasonButtonContainer.getChildren().size() != 0;
        seasonButtonContainer.getChildren().clear();
        if (wasActive)  return;

        seasonButtonContainer.getChildren().setAll(generateSeasonButtons());
    }

    public List<MFXButton> generateLeagueButtons() {

        List<MFXButton> leagueButtons = new ArrayList<>();

        for (League league : mainPane.getLeagues()) {
            MFXButton button = new MFXButton(league.getName());
            button.setOnAction(e -> changeLeague(league));
            leagueButtons.add(button);
        }

        return leagueButtons;
    }

    public List<MFXButton> generateSeasonButtons() {

        List<MFXButton> seasonButtons = new ArrayList<>();

        for (Season season : mainPane.getSeasons()) {
            MFXButton button = new MFXButton(season.getLabel());
            button.setOnAction(e -> changeSeason(season));
            seasonButtons.add(button);
        }

        return seasonButtons;
    }

    public void changeLeague(League league) {
        mainPane.setCurrentLeague(league);
        chooseLeagueButton.setText(league.getName());
        leagueButtonContainer.getChildren().clear();
    }

    public void changeSeason(Season season) {
        mainPane.setCurrentSeason(season);
        chooseSeasonButton.setText(season.getLabel());
        seasonButtonContainer.getChildren().clear();
    }

    public String getLeagueName() {
        return currentLeagueName;
    }
}
