package com.pacholki.entity;

import com.pacholki.controller.Controller;
import com.pacholki.loader.DataGetter;
import com.pacholki.loader.DataWaiter;

public abstract class Entity {

    protected static final String DATA_DIR = "src/main/resources/com/pacholki/data/";
    protected static final String FXML_DIR = "/com/pacholki/fxml/";

    protected Controller controller;
    protected DataGetter getter;

    public void setMe() {
        DataWaiter waiter = new DataWaiter(this, getter);
        waiter.start();
    };

    public Controller getController() {
        return controller;
    }

    public abstract void prepareData();
    public abstract String getFXMLPath();
}
