package com.pacholki.controller;

import com.pacholki.entity.Entity;
import com.pacholki.entity.Team;
import com.pacholki.pane.TeamPane;
import com.pacholki.util.Tools;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class PlayerPageController extends Controller implements Initializable {

    @FXML
    private VBox Goalkeepers;
    @FXML
    private VBox Defenders;
    @FXML
    private VBox Midfielders;
    @FXML
    private VBox Attackers;
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
