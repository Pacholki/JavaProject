package com.pacholki.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.pacholki.entity.Entity;
import com.pacholki.entity.Team;
import com.pacholki.pane.TeamPane;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class TeamController extends Controller implements Initializable {

    private Team team;

    @FXML
    private Label teamName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        teamPane = new TeamPane(this);
        team = teamPane.getCurrentTeam();
        teamName.setText(team.getName());
    }

    @Override
    public void updatePane(Entity entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePane'");
    }
    
}
