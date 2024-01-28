package com.pacholki.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.pacholki.controller.page.team.PlayerPageController;
import com.pacholki.entity.Entity;
import com.pacholki.pane.TeamPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class TeamController extends Controller {

    private final String infoPageFXML = "/com/pacholki/fxml/page/team/infoPage.fxml";
    private final String playerPageFXML = "/com/pacholki/fxml/page/team/playerPage.fxml";
    private final String statsPageFXML = "/com/pacholki/fxml/page/team/statsPage.fxml";
    private final String analysisPageFXML = "/com/pacholki/fxml/page/team/analysisPage.fxml";

    @FXML
    private HBox navbar;
    @FXML
    protected Pane pagePane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        teamPane = new TeamPane(this);
        addButtons();
        updatePagePane(infoPageFXML);
    }

    private void addButtons() {
        navbar.getChildren().clear();
        String[] fxmlPaths = {
            infoPageFXML,
            playerPageFXML,
            statsPageFXML,
            analysisPageFXML
        };
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
    @Override
    public void showLoadScreen(Entity entity) {}
}
