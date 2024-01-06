package com.pacholki.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.pacholki.entity.Entity;
import com.pacholki.pane.LeaguePane;
import com.pacholki.pane.MainPane;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class LeagueController extends Controller implements Initializable {

    @FXML
    private Label leagueNameLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        leaguePane = new LeaguePane(this);
        leagueNameLabel.setText("dupadupa");
        System.out.println(mainPane.getCurrentCompetition());
    }

    @Override
    public void updatePane(Entity entity) {
        System.out.println("this league pane should now be updated");
    }
    
}
