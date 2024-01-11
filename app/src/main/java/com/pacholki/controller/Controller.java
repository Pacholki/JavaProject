package com.pacholki.controller;

import com.pacholki.entity.Entity;
import com.pacholki.pane.LeaguePane;
import com.pacholki.pane.MainPane;
import com.pacholki.pane.TeamPane;

public abstract class Controller {

    protected static MainPane mainPane;
    protected static LeaguePane leaguePane;
    protected static TeamPane teamPane;

    public abstract void updatePane(Entity entity);
}
