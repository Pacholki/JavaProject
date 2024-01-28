package com.pacholki.loader;

import javafx.application.Platform;

public abstract class VisibleDataGetter extends DataGetter{
    @Override
    public void run(int verbose) {
        requests += 1;
        id = requests;

        super.run(verbose);

        boolean isLastUserRequest = (requests == id);
        if (isLastUserRequest) {
            Platform.runLater(() -> entity.getController().updatePane(entity));
        }
    }

    @Override
    protected void customDataAction() {
        entity.prepareData();
    }
}
