package com.pacholki.entity;

import com.pacholki.controller.Controller;
import com.pacholki.changer.DataGetter;
import com.pacholki.changer.DataWaiter;

public abstract class Entity {

    protected Controller controller;
    protected DataGetter getter;
    public abstract void prepareData();

    public void setMe() {
        System.out.println("Trying to set " + toString());
        DataWaiter waiter = new DataWaiter(this, getter);
        waiter.start();
    };

    public Controller getController() {
        return controller;
    }
}
