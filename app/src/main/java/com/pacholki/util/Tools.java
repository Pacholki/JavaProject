package com.pacholki.util;

import java.util.List;

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

    public static <T> void display (T[] array) {
        for (T entry : array) {
            System.out.println(entry);
        }
        System.out.println();
    }

    public static <T> void display (List<T> list) {
        for (T entry : list) {
            System.out.println(entry);
        }
        System.out.println();
    }


}
