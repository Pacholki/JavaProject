package com.pacholki.getter;

import com.pacholki.entity.Entity;

import javafx.application.Platform;

public abstract class DataGetter extends Thread {

    protected static int downloadsStarted = 0;
    protected static int downloadsFinished = 0;
    
    protected final String SCRIPT_DIR = "src/main/python/";

    // protected Entity entity;
    // private Runnable onDataDownloadedCallback;

    // @Override
    // public void run() {
    //     run(1);
    // }

    // public void setOnDataDownloaded(Runnable onDataDownloadedCallback) {
    //     this.onDataDownloadedCallback = onDataDownloadedCallback;
    // }

    // protected void run(int verbose) {
    //     downloadsStarted += 1;
    //     int id = downloadsStarted;

    //     if (verbose > 1) {
    //         System.out.println(id + ". -----\nTrying to download data for:\n" + entity + "\n-----");
    //     }

    //     int exitCode = getData();
    //     downloadsFinished += 1;
    //     int downloadsActive = downloadsStarted - downloadsFinished;

    //     if (exitCode == 0 & verbose > 0) {
    //         System.out.println(id + ". -----\nDownload successful: \n" + entity + "\nActive downloads: " + downloadsActive + "\n-----");
    //     } else if (verbose > 0) {
    //         System.out.println(id + ". -----\nFailed to download: \n" + entity + "\nActive downloads: " + downloadsActive + "\n-----");
    //     }

    //     entity.prepareData();

    //     if (onDataDownloadedCallback != null & downloadsActive == 0) {
    //         Platform.runLater(onDataDownloadedCallback);
    //     }
    // }

    public abstract int getData();
    
}
