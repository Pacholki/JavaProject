package com.pacholki.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.pacholki.entity.*;
import com.pacholki.pane.MainPane;

import com.pacholki.util.Tools;
import io.github.palexdev.materialfx.controls.MFXButton;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class MainController extends Controller {
    
    private String currentLeagueName;

    private List<MFXButton> leagueButtons;
    private List<MFXButton> seasonButtons;

    @FXML
    private MFXButton leagueChoiceButton;
    @FXML
    private VBox leagueButtonContainer;
    @FXML
    private MFXButton seasonChoiceButton;
    @FXML
    private VBox seasonButtonContainer;
    @FXML
    private VBox teamButtonContainer;
    @FXML
    private Pane entityPane;

    @FXML
    private Label warningText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mainPane = new MainPane(this);
        mainPane.loadFirstSeason();
        this.leagueButtons = generateLeagueButtons();
        this.seasonButtons = generateSeasonButtons();
        leagueChoiceButton.setText(mainPane.getCurrentLeague().getName());
        seasonChoiceButton.setText(mainPane.getCurrentSeason().getLabel());
    }

    @FXML
    private void handleLeagueChoice() {

        seasonButtonContainer.getChildren().clear();
        boolean wasActive = leagueButtonContainer.getChildren().size() != 0;
        leagueButtonContainer.getChildren().clear();
        if (wasActive)  return;

        leagueButtonContainer.getChildren().setAll(leagueButtons);
    }

    @FXML
    private void handleSeasonChoice() {

        leagueButtonContainer.getChildren().clear();
        boolean wasActive = seasonButtonContainer.getChildren().size() != 0;
        if (wasActive) {
            seasonButtonContainer.getChildren().clear();
            return;
        }

        seasonButtonContainer.getChildren().setAll(seasonButtons);
    }

    private List<MFXButton> generateLeagueButtons() {

        List<MFXButton> leagueButtons = new ArrayList<>();

        for (League league : mainPane.getLeagues()) {
            MFXButton button = new MFXButton(league.getName());
            button.setOnAction(e -> changeLeague(league));
            leagueButtons.add(button);
        }

        return leagueButtons;
    }

    private List<MFXButton> generateSeasonButtons() {

        List<MFXButton> seasonButtons = new ArrayList<>();

        for (Season season : mainPane.getSeasons()) {
            MFXButton button = new MFXButton(season.getLabel());
            button.setOnAction(e -> changeSeason(season));
            seasonButtons.add(button);
        }

        return seasonButtons;
    }

    public void changeLeague(League league) {
        leagueButtonContainer.getChildren().clear();
        
        if (mainPane.changeCompetition(league)) {
            leagueChoiceButton.setText(league.getName());
        }
    }

    public void changeSeason(Season season) {
        seasonButtonContainer.getChildren().clear();
        if (mainPane.changeCompetition(season)) {
            seasonChoiceButton.setText(season.getLabel());
        }
    }

    public String getLeagueName() {
        return currentLeagueName;
    }

    public void addToCompetitionList(Competition competition) {
        mainPane.tidyCompetitionList(competition);
        mainPane.addCompetition(competition);
        mainPane.setCurrentCompetition(competition);
    }

    @Override
    public void updatePane(Entity entity) {
        Competition competition = (Competition) entity;
        teamButtonContainer.getChildren().setAll(generateTeamButtons(competition));
        
        updateEntityPane(competition);

        mainPane.handleCompetitionUpdate();
        hideWarning();

    }

    public void updateEntityPane(Entity entity) {
        try {
            String fxmlPath = entity.getFXMLPath();
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Pane pane = loader.load();
            entityPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showLoadScreen(Entity entity) {
        try {
            String fxmlPath = entity.getFXML_DIR() + "loadScreen.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Pane pane = loader.load();
            entityPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showError(Entity entity) {
        try {
            String fxmlPath = entity.getFXML_DIR() + "errorScreen.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Pane pane = loader.load();
            entityPane.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showOutdatedDataNotification(Entity entity) {
        warningText.setText("Data can be outdated.");
    }

    public void hideWarning() {
        warningText.setVisible(false);
    }



    public List<MFXButton> generateTeamButtons(Competition competition) {
        List<MFXButton> teamButtons = new ArrayList<>();
        for (Team team : competition.getTeams()) {
            MFXButton button = new MFXButton(team.getName());
            button.setOnAction(e -> viewTeam(team));
            button.getStyleClass().add("teamButton");
            teamButtons.add(button);
        }
        return teamButtons;
    }

    private void viewTeam(Team team) {
        mainPane.setCurrentTeam(team);
        updateEntityPane(team);
    }
}
