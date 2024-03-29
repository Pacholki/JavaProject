package com.pacholki.loader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.pacholki.entity.Entity;

public abstract class DataGetter extends Loader {

    protected final String SCRIPT_DIR = "src/main/python/";

    protected int id;
    protected int verbose = 1;
    protected boolean forceDownload = false;
    protected boolean isAnUpdate = false;
    protected String message;
    protected Entity entity;

    protected List<String> requiredFiles = new ArrayList<>();

    @Override
    public void run() {
        run(verbose);
    }

    public void run(int verbose) {

        addRequiredFiles();
        int exitCode = 0;
        if (isDownloadNecessary()) {
            exitCode = handleNewDownload();
            markUpdated();
            if(exitCode != 0) {
                showError();
                return;
            }
        }
        else if (isAnUpdate) {
            exitCode = handleUpdate();
            markUpdated();
            if(exitCode != 0) {
                showOutdatedDataNotification();
                return;
            }
        } else {
            showSkipDownloadMessage(verbose > 0, message);
        }

        saveCompetition();
        customDataAction();
    }

    private int handleUpdate() {
        showTryDownloadMessage(verbose > 1, message);
        int exitCode = getData();
        showDownloadSuccessfulMessage(exitCode == 0 & verbose > 0, message);
        showDownloadFailedMessage(exitCode != 0 & verbose > 0, message);
        return exitCode;
    }

    private int handleNewDownload() {
        showLoadScreen();
        showTryDownloadMessage(verbose > 1, message);
        int exitCode = getData();
        showDownloadSuccessfulMessage(exitCode == 0 & verbose > 0, message);
        showDownloadFailedMessage(exitCode != 0 & verbose > 0, message);
        return exitCode;
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
    protected void showSkipDownloadMessage(boolean condition, String message) {
        if (! condition) return;
        System.out.println("-----\nSkipping the download of: \n" + entity + "\n" + message +  "\n-----");
    }

    public abstract int getData();
    protected abstract void addRequiredFiles();
    protected abstract void markUpdated();
    protected abstract void showLoadScreen();
    protected abstract void showError();
    protected abstract void showOutdatedDataNotification();

    protected void saveCompetition() {}

    protected void customDataAction() {
        return;
    }

    private boolean isDownloadNecessary() {
        if (filesMissing()) return true;
        return forceDownload;
    }

    private boolean filesMissing() {
        for (String filePath : requiredFiles) {
            File file = new File(filePath);
            if (! file.exists())    return true;
        }
        return false;
    }
}
