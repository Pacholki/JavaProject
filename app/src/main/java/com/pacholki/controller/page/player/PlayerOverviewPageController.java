package com.pacholki.controller.page.player;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import com.pacholki.controller.Controller;
import com.pacholki.entity.Entity;
import com.pacholki.entity.Player;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;



public class PlayerOverviewPageController extends Controller {

    private Player currentPlayer;

    @FXML
    private ImageView playerImage;
    @FXML
    private Label playerNameText;
    @FXML
    private Label teamNameText;
    @FXML
    private Label ageText;
    @FXML
    private Label positionsText;
    @FXML
    private Label matchesPlayedText;
    @FXML
    private Label first11Text;
    @FXML
    private Label playTimeMinutes;
    @FXML
    private Label goalsText;
    @FXML
    private Label assistsText;
    @FXML
    private Label yellowCardsText;
    @FXML
    private Label redCardsText;
    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    public void setPlayer(Player player) {
        currentPlayer = player;
        updatePlayerInformation();
    }

    private void updatePlayerInformation() {
        if (currentPlayer != null) {
            setImage(playerImage);
            playerNameText.setText(String.valueOf(currentPlayer.getPlayerName()));
            teamNameText.setText("Team: " + String.valueOf(currentPlayer.getTeamName()));
            ageText.setText("Birthyear: " + String.valueOf(currentPlayer.getBirthYear()) + "      Age: " + String.valueOf(currentPlayer.getAge().substring(0,2)) );
            positionsText.setText("Positions: " + String.valueOf(currentPlayer.getPosition()));
            matchesPlayedText.setText("Matches Played: " + String.valueOf(currentPlayer.getPlayingTimeMP()));
            first11Text.setText("First 11: " + String.valueOf(currentPlayer.getPlayingTimeStarts()));
            playTimeMinutes.setText("Playtime: " + String.valueOf(currentPlayer.getPlayingTimeMin()) + " minutes");
            goalsText.setText("Goals: " + String.valueOf(currentPlayer.getPerformanceGoals()));
            assistsText.setText("Assists: " + String.valueOf(currentPlayer.getPerformanceAssists()));
            yellowCardsText.setText("Yellow Cards: " + String.valueOf(currentPlayer.getPerformanceYellowCards()));
            redCardsText.setText("Red Cards: " + String.valueOf(currentPlayer.getPerformanceRedCards()));
        }

    }

    private void setImage(ImageView image) {
        String imagePath = "/com/pacholki/media/generic/pudzian.png";
        if (currentPlayer.getPlayerName().startsWith("Kylian")) {
            imagePath = "/com/pacholki/media/generic/mbappe.jpg";
        }
        if (currentPlayer.getPlayerName().startsWith("Adama")) {
            imagePath = "/com/pacholki/media/generic/traore.jpg";
        }
        if (currentPlayer.getPlayerName().startsWith("Lionel")) {
            imagePath = "/com/pacholki/media/generic/Messi.jpg";
        }
        if (currentPlayer.getPlayerName().startsWith("Robert L")) {
            imagePath = "/com/pacholki/media/generic/robercik.jpg";
        }
        InputStream inputStream = getClass().getResourceAsStream(imagePath);
        Image img = new Image(inputStream);
        image.setImage(img);
    }


    @Override
    public void updatePane(Entity entity) {}
    @Override
    public void showLoadScreen(Entity entity) {}
}