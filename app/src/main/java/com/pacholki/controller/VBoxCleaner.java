package com.pacholki.controller;

import javafx.scene.layout.VBox;

public class VBoxCleaner extends Thread {

    VBox box;

    public VBoxCleaner(VBox box) {
        this.box = box;
    }
    
    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        box.getChildren().clear();
    }
}
