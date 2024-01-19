package com.pacholki.controller;

import com.pacholki.entity.Entity;
import com.pacholki.entity.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class PlayerOverviewPageController extends Controller implements Initializable {

    @FXML
    private Label text;

    private Player currentPlayer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void setPlayer(Player player) {
        currentPlayer = player;
        updatePlayerInfo();
    }

    private void updatePlayerInfo() {
        if (currentPlayer != null) {
            text.setText("Player Name: " + currentPlayer.getPlayerName() + "\n"
                    + "Position: " + currentPlayer.getPrimaryPosition());
        }
    }

    @Override
    public void updatePane(Entity entity) {
    }
}

