package com.pacholki.util;

import java.util.ArrayList;

public abstract class Tools {
    
    public static <T> void display(T[] array) {
        for (T entry : array) {
            System.out.println(entry);
        }
        System.out.println();
    }

    public static <T> void display(ArrayList<T> array) {
        for (T entry : array) {
            System.out.println(entry);
        }
        System.out.println();
    }
}
