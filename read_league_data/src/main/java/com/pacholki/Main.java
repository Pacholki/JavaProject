package com.pacholki;


public class Main {
    public static void main(String[] args) {
        
        MainPane mainPane = new MainPane();
        mainPane.readLeagues();
        mainPane.readSeasons();
        mainPane.getData();
    }
}