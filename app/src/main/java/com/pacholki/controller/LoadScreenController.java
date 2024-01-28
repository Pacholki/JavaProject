package com.pacholki.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.pacholki.entity.Entity;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class LoadScreenController extends Controller {

    @FXML
    private Shape loadShape;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("controlling something");

        Timeline timeline = new Timeline(
            new KeyFrame(Duration.ZERO, new KeyValue(loadShape.fillProperty(), Color.WHITE)),
            new KeyFrame(Duration.seconds(1), new KeyValue(loadShape.fillProperty(), Color.WHITESMOKE)),
            new KeyFrame(Duration.seconds(2), new KeyValue(loadShape.fillProperty(), Color.GRAY)),
            new KeyFrame(Duration.seconds(3), new KeyValue(loadShape.fillProperty(), Color.WHITE))
        );

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    @Override
    public void updatePane(Entity entity) {}
    @Override
    public void showLoadScreen(Entity entity) {}

}
