package com.pacholki.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
// import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LeagueOverviewController implements Initializable {

    private String leagueName;

    @FXML
    private AnchorPane root;

    @FXML
    private Button exitButton;

    @FXML
    private Button minimiseButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        exitButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> Platform.exit());
        minimiseButton.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> ((Stage) root.getScene().getWindow()).setIconified(true));
    }


    // @FXML
    // private VBox leagueButtonContainer;
    // @FXML
    // private Button chooseLeague;

    // @FXML
    // private void handleSelectLeague() {
    //     System.out.println("Select button clicked!");

    //     boolean wasActive = leagueButtonContainer.getChildren().size() != 0;
    //     leagueButtonContainer.getChildren().clear();
    //     if (wasActive)  return;

    //     Button premierLeagueButton = new Button("Premier League");
    //     Button laLigaButton = new Button("La Liga");
    //     Button ligueOneButton = new Button("Ligue One");
    //     Button serieAButton = new Button("Serie A");
    //     Button bundesligaButton = new Button("Bundesliga");
    //     premierLeagueButton.setOnAction(e -> handleLeagueButtonClick("Premier League"));
    //     laLigaButton.setOnAction(e -> handleLeagueButtonClick("La Liga"));
    //     ligueOneButton.setOnAction(e -> handleLeagueButtonClick("Ligue One"));
    //     serieAButton.setOnAction(e -> handleLeagueButtonClick("Serie A"));
    //     bundesligaButton.setOnAction(e -> handleLeagueButtonClick("Bundesliga"));
    //     leagueButtonContainer.getChildren().add(premierLeagueButton);
    //     leagueButtonContainer.getChildren().add(laLigaButton);
    //     leagueButtonContainer.getChildren().add(ligueOneButton);
    //     leagueButtonContainer.getChildren().add(serieAButton);
    //     leagueButtonContainer.getChildren().add(bundesligaButton);
    // }

    // private void handleLeagueButtonClick(String leagueName) {
    //     this.leagueName = leagueName;
    //     System.out.println("You have chosen the league: " + leagueName);
    //     leagueButtonContainer.getChildren().clear();
    //     chooseLeague.setText(leagueName);
    // }

    // public String getLeagueName() {
    //     return leagueName;
    // }
}
