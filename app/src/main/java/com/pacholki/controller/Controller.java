package com.pacholki.controller;

import com.pacholki.entity.Entity;
import com.pacholki.pane.CompetitionPane;
import com.pacholki.pane.MainPane;
import com.pacholki.pane.TeamPane;

import javafx.fxml.Initializable;

public abstract class Controller implements Initializable {

    protected static MainPane mainPane;
    protected static CompetitionPane competitionPane;
    protected static TeamPane teamPane;

    public abstract void updatePane(Entity entity);
    public abstract void showLoadScreen(Entity entity);
    public abstract void showError(Entity entity);
    public abstract void showOutdatedDataNotification(Entity entity);
}
