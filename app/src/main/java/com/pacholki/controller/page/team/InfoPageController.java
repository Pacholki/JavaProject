package com.pacholki.controller.page.team;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import com.pacholki.controller.Controller;
import com.pacholki.entity.Entity;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class InfoPageController extends Controller {

    @FXML
    private ImageView teamImage;
    @FXML
    private Label teamNameText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setImage(teamImage);
        teamNameText.setText(competitionPane.getCurrentTeam().getName());
    }

    private void setImage(ImageView image) {
        String imagePath = "/com/pacholki/media/generic/pudzian.png";
        InputStream inputStream = getClass().getResourceAsStream(imagePath);
        Image img = new Image(inputStream);
        image.setImage(img);
    }

    @Override
    public void updatePane(Entity entity) {}
}
