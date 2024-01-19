package com.pacholki;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;  
import javafx.scene.media.MediaPlayer;  
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Paths;

import com.pacholki.util.MusicPlayer;


public class App extends Application {

    private static Scene scene;
    private static MusicPlayer musicPlayer;

    @Override
    public void start(Stage stage) throws IOException {

        String cssFilePath = "css/main.css";
        String css = getClass().getResource(cssFilePath).toExternalForm();

        scene = new Scene(loadFXML("main"), 920, 640);
        scene.getStylesheets().add(css);

        stage.setTitle("Football Dashboard");
        stage.setScene(scene);
        stage.show();
        musicPlayer = new MusicPlayer();
        musicPlayer.playMusic();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("fxml/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    // public static void main(String[] args) {
    //     launch();
    // }
}