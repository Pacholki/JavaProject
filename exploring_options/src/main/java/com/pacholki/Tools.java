package com.pacholki;

public abstract class Tools {
    public static <T> void display(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
        System.out.println();
    }
}
