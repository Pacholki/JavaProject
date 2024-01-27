package com.pacholki.changer;

import com.pacholki.entity.Entity;

public abstract class DataGetter extends Changer {

    protected final String SCRIPT_DIR = "src/main/python/";

    protected int id;
    protected int verbose = 1;
    protected boolean skipDownload = true;
    protected String message;
    protected Entity entity;

    @Override
    public void run() {
        run(verbose);
    }

    public void run(int verbose) {

        showTryDownloadMessage(verbose > 1, message);

        if (! isDataAvailable()) {
            int exitCode = getData();
            showDownloadSuccessfulMessage(exitCode == 0 & verbose > 0, message);
            showDownloadFailedMessage(exitCode != 0 & verbose > 0, message);
        }

        customDataAction();
    }

    protected void showTryDownloadMessage(boolean condition, String message) {
        if (! condition) return;
        System.out.println("-----\nTrying to download data for:\n" + entity + "\n-----");
    }
    protected void showDownloadSuccessfulMessage (boolean condition, String message) {
        if (! condition) return;
        System.out.println("-----\nDownload successful: \n" + entity + "\n" + message + "\n-----");
    }
    protected void showDownloadFailedMessage(boolean condition, String message) {
        if (! condition) return;
        System.out.println("-----\nFailed to download: \n" + entity + "\n" + message +  "\n-----");
    }

    public abstract int getData();
    protected abstract boolean isDataAvailable();

    protected void customDataAction() {
        return;
    }
}
