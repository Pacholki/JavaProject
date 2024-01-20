package com.pacholki.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.pacholki.controller.page.team.PlayerPageController;
import com.pacholki.entity.Entity;
import com.pacholki.entity.Team;
import com.pacholki.pane.TeamPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class TeamController extends Controller {

    private Team team;

    @FXML
    private HBox navbar;
    @FXML
    private Label teamName;
    @FXML
    protected Pane pagePane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        teamPane = new TeamPane(this);
        team = teamPane.getCurrentTeam();
        teamName.setText(team.getName());
        addButtons();
    }

    private void addButtons() {
        navbar.getChildren().clear();
        String[] fxmlPaths = {"/com/pacholki/fxml/page/team/infoPage.fxml",
                "/com/pacholki/fxml/page/team/playerPage.fxml",
                "/com/pacholki/fxml/page/team/statsPage.fxml",
                "/com/pacholki/fxml/page/team/analysisPage.fxml"};
        String[] buttonLabels = {"InfoPage", "Players", "Stats", "Advanced"};
        for(int i=0; i < buttonLabels.length; i++) {
            Button button = new Button(buttonLabels[i]);
            int finalI = i;
            button.setOnAction(e -> updatePagePane(fxmlPaths[finalI]));
            navbar.getChildren().add(button);
        }
    }

    public void updatePagePane(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Pane pane = loader.load();

            if (loader.getController() instanceof PlayerPageController) {
                PlayerPageController playerPageController = (PlayerPageController) loader.getController();
                playerPageController.setPagePane(pagePane);
            }
            pagePane.getChildren().setAll(pane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updatePane(Entity entity) {}
}
