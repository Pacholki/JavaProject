package com.pacholki.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.pacholki.entity.Entity;
import com.pacholki.entity.Team;
import com.pacholki.pane.Page;
import com.pacholki.pane.PlayerPage;
import com.pacholki.pane.TeamPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class TeamController extends Controller implements Initializable {

    private Team team;

    @FXML
    private HBox navbar;
    @FXML
    private Label teamName;
    @FXML
    private Pane pagePane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        teamPane = new TeamPane(this);
        team = teamPane.getCurrentTeam();
        teamName.setText(team.getName());
        addButtons();
    }

    private void addButtons() {
        navbar.getChildren().clear();
        String[] fxmlPaths = {"/com/pacholki/fxml/infoPage.fxml", "/com/pacholki/fxml/playerPage.fxml"};
        String[] buttonLabels = {"InfoPage", "Players"};
        for(int i=0; i < buttonLabels.length; i++) {
            Button button = new Button(buttonLabels[i]);
            int finalI = i;
            button.setOnAction(e -> updatePagePane(fxmlPaths[finalI]));
            navbar.getChildren().add(button);
        }
    }

    private void updatePagePane(String fxmlPath) {
        try {
            System.out.println(fxmlPath);
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Pane pane = loader.load();
            pagePane.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void updatePane(Entity entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePane'");
    }
    
}
