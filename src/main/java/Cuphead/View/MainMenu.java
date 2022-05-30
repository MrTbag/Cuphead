package Cuphead.View;

import Cuphead.App;
import Cuphead.Controller.ColorController;
import Cuphead.Controller.Controller;
import Cuphead.Controller.Time;
import Cuphead.Controller.UserController;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MainMenu {
    public BorderPane borderPane;

    public void newGame(MouseEvent mouseEvent) throws InterruptedException {
        App.changeMenu("GameMenu");
        App.setMediaPlayer();
    }

    public void continueGame(MouseEvent mouseEvent) {
    }

    public void profile(MouseEvent mouseEvent) {
        App.changeMenu("ProfileMenu");
    }

    public void scoreBoard(MouseEvent mouseEvent) {
        App.changeMenu("ScoreBoard");
    }

    public void quit(MouseEvent mouseEvent) {
    }

    public void settings(MouseEvent mouseEvent) {
        App.changeMenu("SettingsMenu");
    }

    public void initialize(){
        if (ColorController.grayScale){
            ColorController.setGrayScale(borderPane);
        }
    }
}
