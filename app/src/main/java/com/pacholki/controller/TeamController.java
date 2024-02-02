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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class TeamController extends Controller {

    private final String infoPageFXML = "/com/pacholki/fxml/page/team/infoPage.fxml";
    private final String playerPageFXML = "/com/pacholki/fxml/page/team/playerPage.fxml";
    private final String statsPageFXML = "/com/pacholki/fxml/page/team/statsPage.fxml";
    private final String analysisPageFXML = "/com/pacholki/fxml/page/team/analysisPage.fxml";

    @FXML
    private GridPane gridPane;
    @FXML
    private HBox navbar;
    @FXML
    protected Pane pagePane;
    @FXML
    private Button infoButton;
    @FXML
    private Button playerButton;
    @FXML
    private Button statsButton;
    @FXML
    private Button advancedButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        teamPane = new TeamPane(this);
        addButtons();
        updatePagePane(infoPageFXML);
    }

    private void addButtons() {
        String[] fxmlPaths = {
            infoPageFXML,
            playerPageFXML,
            statsPageFXML,
            analysisPageFXML
        };
        Button[] pageButtons = {infoButton, playerButton, statsButton, advancedButton};
        String[] buttonLabels = {"InfoPage", "Players", "Stats", "Advanced"};
        int i = 0;
        for(Button button : pageButtons) {
            int finalI = i;
            button.setText(buttonLabels[i]);
            button.setOnAction(e -> updatePagePane(fxmlPaths[finalI]));
            i++;
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
    @Override
    public void showError(Entity entity) {}
    @Override
    public void showOutdatedDataNotification(Entity entity) {}
}
