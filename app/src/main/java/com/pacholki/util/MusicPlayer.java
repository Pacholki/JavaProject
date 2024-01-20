package com.pacholki.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicPlayer {
    private List<File> songs;
    private final File directory;
    private int currentSongIndex;
    private MediaPlayer mediaPlayer;
    private Media media;

    public MusicPlayer() {
        songs = new ArrayList<>();
        directory = new File("src\\main\\resources\\com\\pacholki\\media");
        File[] files = directory.listFiles();
        
        if (files != null) {
            for (File file : files) {
                songs.add(file);
            }
        }

        initMediaPlayer();
    }

    private void initMediaPlayer() {
        media = new Media(songs.get(currentSongIndex).toURI().toString());
        mediaPlayer = new MediaPlayer(media);

        mediaPlayer.setOnEndOfMedia(() -> playNextSong());
    }

    public void playMusic() {
        mediaPlayer.play();
    }

    private void playNextSong() {
        mediaPlayer.stop();
        currentSongIndex = (currentSongIndex + 1) % songs.size();
        initMediaPlayer();
        playMusic();
    }
}
