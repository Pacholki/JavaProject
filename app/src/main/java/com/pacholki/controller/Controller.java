package com.pacholki.controller;

import com.pacholki.entity.Entity;
import com.pacholki.pane.CompetitionPane;
import com.pacholki.pane.MainPane;
import com.pacholki.pane.TeamPane;

public abstract class Controller {

    protected static MainPane mainPane;
    protected static CompetitionPane competitionPane;
    protected static TeamPane teamPane;

    protected static PlayerPage playerPage;

    public abstract void updatePane(Entity entity);
}
