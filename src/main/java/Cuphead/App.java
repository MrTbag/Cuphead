package Cuphead;

import Cuphead.View.GameMenu;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.net.URL;

public class App extends Application {
    private static Scene scene;
    public static Parent root;
    private static MediaPlayer mediaPlayer;

    public static void main(String[] args) throws InterruptedException {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
//        User.loadUsers();
        Media media = new Media(getClass().getResource("/Cuphead/Music/13 Floral Fury.mp3").toExternalForm());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        Parent root = loadFXML("LoginMenu");
        App.root = root;
        Scene scene = new Scene(root);
        App.scene = scene;
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("CupHead");
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {

            }
        });
    }

    public static void changeMenu(String name){
        Parent root = loadFXML(name);
        App.root = root;
        App.scene.setRoot(root);
    }
    private static Parent loadFXML(String name){
        try {
            URL address = new URL(App.class.getResource("FXML/" + name + ".fxml").toExternalForm());
            return FXMLLoader.load(address);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setMediaPlayer(){
        mediaPlayer.stop();
        mediaPlayer = new MediaPlayer(new Media(App.class.getResource("/Cuphead/Music/26 Pyramid Peril.mp3").toExternalForm()));
        mediaPlayer.setAutoPlay(true);
        if (GameMenu.muted)
            App.muteMediaPlayer();
    }

    public static void muteMediaPlayer(){
        mediaPlayer.setMute(true);
    }

    public static void unmuteMediaPlayer(){
        mediaPlayer.setMute(false);
    }




}
