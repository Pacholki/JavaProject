package com.pacholki;

public class Tools {

    private static long startTime;
    private static long endTime;
    
    public static void startTimer() {
        startTime = System.currentTimeMillis();
    }
    public static void endTimer() {
        endTime = System.currentTimeMillis();
        System.out.println("action time = " + (endTime - startTime));
    }

}
