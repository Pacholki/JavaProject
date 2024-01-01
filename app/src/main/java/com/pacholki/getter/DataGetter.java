package com.pacholki.getter;

import com.pacholki.entity.Entity;

import javafx.application.Platform;

public abstract class DataGetter extends Thread {

    protected final String SCRIPT_DIR = "src/main/python/";

    private static int downloadsStarted = 0;
    private static int downloadsFinished = 0;

    protected Entity entity;
    private Runnable onDataDownloadedCallback;

    @Override
    public void run() {
        run(1);
    }

    public void setOnDataDownloaded(Runnable onDataDownloadedCallback) {
        this.onDataDownloadedCallback = onDataDownloadedCallback;
    }

    public void run(int verbose) {
        downloadsStarted += 1;
        int id = downloadsStarted;

        showTryDownloadMessage(verbose > 1, id);

        int exitCode = getData();
        downloadsFinished += 1;
        int downloadsActive = downloadsStarted - downloadsFinished;

        showDownloadSuccessfulMessage(exitCode == 0 & verbose > 0, id, downloadsActive);
        showDownloadFailedMessage(exitCode != 0 & verbose > 0, id, downloadsActive);

        entity.prepareData();

        boolean isLastUserRequest = (downloadsStarted == id);
        if (onDataDownloadedCallback != null & isLastUserRequest) {
            Platform.runLater(onDataDownloadedCallback);
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
