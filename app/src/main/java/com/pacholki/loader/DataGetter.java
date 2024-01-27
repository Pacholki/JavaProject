package com.pacholki.loader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.pacholki.entity.Entity;

public abstract class DataGetter extends Loader {

    protected final String SCRIPT_DIR = "src/main/python/";

    protected int id;
    protected int verbose = 1;
    protected boolean skipDownload = true;
    protected String message;
    protected Entity entity;

    protected List<String> requiredFiles = new ArrayList<>();

    @Override
    public void run() {
        run(verbose);
    }

    public void run(int verbose) {

        if (! isDataAvailable()) {
            showTryDownloadMessage(verbose > 1, message);
            int exitCode = getData();
            showDownloadSuccessfulMessage(exitCode == 0 & verbose > 0, message);
            showDownloadFailedMessage(exitCode != 0 & verbose > 0, message);
        }
        else {
            showSkipDownloadMessage(message);
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
    protected void showSkipDownloadMessage(String message) {
        System.out.println("-----\nSkipping the download of: \n" + entity + "\n" + message +  "\n-----");
    }

    public abstract int getData();
    protected abstract void addRequiredFiles();

    protected void customDataAction() {
        return;
    }

    private boolean isDataAvailable() {
        if (filesMissing()) return false;
        if (skipDownload)   return true;
        return false;
    }

    private boolean filesMissing() {
        addRequiredFiles();
        for (String filePath : requiredFiles) {
            File file = new File(filePath);
            if (! file.exists())    return true;
        }

        return false;
    }
}
