package com.pacholki.changer;

import javafx.application.Platform;

public abstract class VisibleDataGetter extends DataGetter{
    @Override
    public void run(int verbose) {
        requests += 1;
        id = requests;

        super.run(verbose);

        requestsReady += 1;
        int downloadsActive = requests - requestsReady;

        entity.prepareData();

        boolean isLastUserRequest = (requests == id);
        if (isLastUserRequest) {
            Platform.runLater(() -> entity.getController().updatePane(entity));
        }
    }
}
