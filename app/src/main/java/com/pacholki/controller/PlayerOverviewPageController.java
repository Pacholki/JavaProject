package com.pacholki.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.pacholki.entity.Entity;
import com.pacholki.entity.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PlayerOverviewPageController extends Controller {

    @FXML
    private Label text;
    @FXML
    private Label teamLabel;
    @FXML
    private Label nationLabel;
    @FXML
    private Label positionLabel;

    private Player currentPlayer;


    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    public void setPlayer(Player player) {
        currentPlayer = player;
        updatePlayerInformation();
    }

    private void updatePlayerInformation() {
        if (currentPlayer != null) {
            text.setText(currentPlayer.getPlayerName());
            teamLabel.setText(currentPlayer.getTeam().getName());
            nationLabel.setText(currentPlayer.getNation());
            positionLabel.setText(currentPlayer.getPosition());
        }
    }

    @Override
    public void updatePane(Entity entity) {}
}