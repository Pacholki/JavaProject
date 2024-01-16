package com.pacholki.changer;

import com.pacholki.entity.Entity;
import javafx.application.Platform;

public abstract class DataGetter extends Changer {

    protected final String SCRIPT_DIR = "src/main/python/";

    protected Entity entity;

    protected int id;

    protected String message;

    protected int verbose = 1;

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
        System.out.println("-----\nDownload successful: \n" + entity + "\n" + message + "\n-----");
    }
    protected void showDownloadFailedMessage(boolean condition, String message) {
        if (! condition) return;
        System.out.println("-----\nFailed to download: \n" + entity + "\n" + message +  "\n-----");
    }

    public abstract int getData();
    
}
