package Cuphead;

import Cuphead.Model.User;
import Cuphead.View.GameMenu;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class App extends Application {
    private static Scene scene;
    public static Parent root;
    private static MediaPlayer mediaPlayer;
    public static Stage stage;

    public static void main(String[] args) throws InterruptedException {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        App.stage = stage;
        Gson gson = new GsonBuilder().create();
        if (gson.fromJson(loadFromFile("users.json"), new TypeToken<List<User>>(){}.getType()) != null)
            User.setAllUsers(gson.fromJson(loadFromFile("users.json"), new TypeToken<List<User>>(){}.getType()));
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
                Gson gson = new GsonBuilder().create();
                String jsonString = gson.toJson(User.getAllUsers());
                try {
                    savetoFile("users.json", jsonString);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
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

    private void savetoFile(String fileName, String text) throws FileNotFoundException {
        File file = new File(fileName);
        PrintWriter printWriter = new PrintWriter(file);
        printWriter.write(text);
        printWriter.close();
    }

    private String loadFromFile(String fileName) throws IOException {
        File file = new File(fileName);
        FileInputStream fileInputStream = new FileInputStream(file);
        String text = new String(fileInputStream.readAllBytes());
        fileInputStream.close();
        return text;
    }




}
