package com.pacholki.changer;

import com.pacholki.entity.Entity;
import javafx.application.Platform;

public abstract class DataGetter extends Changer {

    protected final String SCRIPT_DIR = "src/main/python/";

    protected Entity entity;

    @Override
    public void run() {
        run(1);
    }

    public void run(int verbose) {
        requests += 1;
        int id = requests;

        showTryDownloadMessage(verbose > 1, id);

        int exitCode = getData();
        requestsReady += 1;
        int downloadsActive = requests - requestsReady;

        showDownloadSuccessfulMessage(exitCode == 0 & verbose > 0, id, downloadsActive);
        showDownloadFailedMessage(exitCode != 0 & verbose > 0, id, downloadsActive);

        entity.prepareData();

        boolean isLastUserRequest = (requests == id);
        if (isLastUserRequest) {
            Platform.runLater(() -> entity.getController().updatePane(entity));
        }
    }

    private void showTryDownloadMessage(boolean condition, int id) {
        if (! condition) return;
        System.out.println(id + ". -----\nTrying to download data for:\n" + entity + "\n-----");
    }
    private void showDownloadSuccessfulMessage (boolean condition, int id, int downloadsActive) {
        if (! condition) return;
        System.out.println(id + ". -----\nDownload successful: \n" + entity + "\nActive downloads: " + downloadsActive + "\n-----");
    }
    private void showDownloadFailedMessage(boolean condition, int id, int downloadsActive) {
        if (! condition) return;
        System.out.println(id + ". -----\nFailed to download: \n" + entity + "\nActive downloads: " + downloadsActive + "\n-----");
    }

    public abstract int getData();
    
}
