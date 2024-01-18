package com.pacholki.controller;

import com.pacholki.entity.Entity;
import com.pacholki.entity.Team;
import com.pacholki.pane.TeamPane;
import com.pacholki.util.Tools;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class PlayerPageController extends Controller implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        generatePlayersList(teamPane.getCurrentTeam());
    }

    public void generatePlayersList(Team team){
        Tools.display(team.getPlayers());
    }

    @Override
    public void updatePane(Entity entity) {
    }
}
