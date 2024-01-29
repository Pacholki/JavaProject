package com.pacholki.controller;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import com.pacholki.entity.Entity;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class ErrorScreenController extends Controller {

    @FXML
    private ImageView pudzianError;
    @FXML
    private Label errorText;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        errorText.setText("Coś poszło nie tak, ale i tak to by nic nie dało, nie dałoby nic...");
        setImage(pudzianError);
    }

    private void setImage(ImageView image) {
        String imagePath = "/com/pacholki/media/generic/pudzian.png";
        InputStream inputStream = getClass().getResourceAsStream(imagePath);
        Image img = new Image(inputStream);
        image.setImage(img);
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
