package com.pacholki.controller.page.player;

import java.awt.*;
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
    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    public void setPlayer(Player player) {
        currentPlayer = player;
        updatePlayerInformation();
    }

    private void updatePlayerInformation() {
        if (currentPlayer != null) {
            setImage(playerImage);
            playerNameText.setText(currentPlayer.getPlayerName());
            teamNameText.setText("Team: " + currentPlayer.getTeamName());
            ageText.setText("Birthyear: " + currentPlayer.getBirthYear() + "      Age: " + currentPlayer.getAge().substring(0,2));
            positionsText.setText("Positions: " + currentPlayer.getPosition());
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
}