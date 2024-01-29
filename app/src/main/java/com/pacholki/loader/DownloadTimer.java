package com.pacholki.loader;

public class DownloadTimer extends Thread {

    private int waitTimeMilis;
    private Process process;
    public DownloadTimer(int waitTime, Process process) {
        this.waitTimeMilis = waitTime;
        this.process = process;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(waitTimeMilis);
            if(process.isAlive()) {process.destroy();}
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
