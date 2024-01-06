package com.pacholki.controller;

import com.pacholki.entity.Entity;
import com.pacholki.pane.LeaguePane;
import com.pacholki.pane.MainPane;

public abstract class Controller {

    protected static MainPane mainPane;
    protected static LeaguePane leaguePane;

    public abstract void updatePane(Entity entity);
}
