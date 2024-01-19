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

public class App extends Application {

    private static Scene scene;
    private static MediaPlayer mediaPlayer;

    @Override
    public void start(Stage stage) throws IOException {

        String cssFilePath = "css/main.css";
        String css = getClass().getResource(cssFilePath).toExternalForm();

        scene = new Scene(loadFXML("main"), 920, 640);
        scene.getStylesheets().add(css);

        stage.setTitle("Football Dashboard");
        stage.setScene(scene);
        stage.show();
//        playMusic();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("fxml/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public void playMusic() {
        String path = "src\\main\\resources\\com\\pacholki\\media\\Circo Loco.mp3";
        Media h = new Media(Paths.get(path).toUri().toString());
        mediaPlayer = new MediaPlayer(h);
        mediaPlayer.play();
    }
}