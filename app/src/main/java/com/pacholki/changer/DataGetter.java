package com.pacholki.changer;

import com.pacholki.entity.Entity;

public abstract class DataGetter extends Changer {

    protected final String SCRIPT_DIR = "src/main/python/";

    private static int downloadsSuccessful = 0;
    private static int downloadsFailed = 0;

    protected int id;
    protected int verbose = 1;
    protected String message;
    protected Entity entity;

    @Override
    public void run() {
        run(verbose);
    }

    public void run(int verbose) {

        showTryDownloadMessage(verbose > 1, message);

        int exitCode = getData();

        showDownloadSuccessfulMessage(exitCode == 0 & verbose > 0, message);
        showDownloadFailedMessage(exitCode != 0 & verbose > 0, message);
    }

    protected void showTryDownloadMessage(boolean condition, String message) {
        if (! condition) return;
        System.out.println("-----\nTrying to download data for:\n" + entity + "\n-----");
    }
    protected void showDownloadSuccessfulMessage (boolean condition, String message) {
        if (! condition) return;
        downloadsSuccessful++;
        System.out.println("-----\nDownload successful: \n" + entity + "\n" + message + "\n-----");
    }
    protected void showDownloadFailedMessage(boolean condition, String message) {
        if (! condition) return;
        downloadsFailed++;
        System.out.println("-----\nFailed to download: \n" + entity + "\n" + message +  "\n-----");
    }

    public abstract int getData();
    
}
