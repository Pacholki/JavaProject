package com.pacholki.controller.page.team;

import com.pacholki.controller.TeamController;
import com.pacholki.controller.page.player.PlayerOverviewPageController;
import com.pacholki.entity.Entity;
import com.pacholki.entity.Player;
import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class PlayerPageController extends TeamController {

    @FXML
    private VBox goalkeepersBox;
    @FXML
    private VBox defendersBox;
    @FXML
    private VBox midfieldersBox;
    @FXML
    private VBox forwardsBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        goalkeepersBox.getChildren().addAll(generatePlayersButtons("GK"));
        defendersBox.getChildren().addAll(generatePlayersButtons("DF"));
        midfieldersBox.getChildren().addAll(generatePlayersButtons("MF"));
        forwardsBox.getChildren().addAll(generatePlayersButtons("FW"));
    }

    public List<Player> getPlayersByPosition(String position) {
        List<Player> players = teamPane.getCurrentTeam().getPlayers();
        return players.stream()
                .filter(player -> player.getPrimaryPosition().equals(position))
                .collect(Collectors.toList());
    }
    public List<MFXButton> generatePlayersButtons(String position){
        List<MFXButton> playerButtons = new ArrayList<>();
        for (Player player : getPlayersByPosition(position)) {
            MFXButton button = new MFXButton(player.getPlayerName());
            button.setOnAction(e -> updatePlayerPagePane(player));
            button.getStyleClass().add("teamButton");
            playerButtons.add(button);
        }
        return playerButtons;
    }

    public void updatePlayerPagePane(Player player) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/pacholki/fxml/page/player/playerOverviewPage.fxml"));
            Pane pane = loader.load();
            pagePane.getChildren().setAll(pane);
            PlayerOverviewPageController playerOverviewPageController = (PlayerOverviewPageController) loader.getController();
            playerOverviewPageController.setPlayer(player);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setPagePane(Pane pagePane) {
        this.pagePane = pagePane;
    }

    @Override
    public void updatePane(Entity entity) {}
}
