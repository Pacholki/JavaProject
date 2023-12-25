package com.pacholki.controller;

import java.util.List;
import java.util.ResourceBundle;
import java.net.URL;
import java.util.ArrayList;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

public class MainController implements Initializable {

    List<MFXButton> buttons;

    @FXML
    private VBox addedButtonsContainer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.buttons = generateButtons(5);
    }

    @FXML
    private void addButtons() {
        System.out.println("click!");

        boolean wasActive = addedButtonsContainer.getChildren().size() > 0;
        addedButtonsContainer.getChildren().clear();
        if (wasActive)  return;

        addedButtonsContainer.getChildren().setAll(buttons);

    }

    private List<MFXButton> generateButtons(int buttonCount) {

        List<MFXButton> buttons = new ArrayList<>();

        for (int i = 0; i < buttonCount; i++) {

            String buttonName = "button " + (i+1);
            MFXButton button = new MFXButton(buttonName);
            button.setOnAction(e -> System.out.println(buttonName));
            buttons.add(button);
        }
        
        return buttons;
    }
}
