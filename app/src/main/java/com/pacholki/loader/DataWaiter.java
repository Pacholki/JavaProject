package com.pacholki.loader;

import com.pacholki.controller.Controller;
import com.pacholki.entity.Entity;
import javafx.application.Platform;

public class DataWaiter extends Loader {

    Entity entity;
    Controller controller;
    DataGetter getter;

    public DataWaiter(Entity entity, DataGetter getter) {
        this.entity = entity;
        this.controller = entity.getController();
        this.getter = getter;
    }

    @Override
    public void run() {

        requests += 1;
        int id = requests;

        try {
            getter.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        requestsReady += 1;

        boolean isLastUserRequest = (requests == id);
        if (isLastUserRequest) {
            Platform.runLater(() -> controller.updatePane(entity));
        }

    }



}
