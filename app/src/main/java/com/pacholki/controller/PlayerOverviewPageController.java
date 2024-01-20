package com.pacholki.controller;

import com.pacholki.entity.Entity;
import com.pacholki.entity.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PlayerOverviewPageController extends Controller{

    @FXML
    private Label text;
    @FXML
    private Label teamLabel;
    @FXML
    private Label nationLabel;
    @FXML
    private Label positionLabel;

    private Player currentPlayer;

    public void initialize() {
        // w inicie nic bo wywala bo jeszcze nie ma załadowanego currentPlayer dlatego wszystko
        // w updatePlayerInformation()
    }

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
    public void updatePane(Entity entity) {
    }
}