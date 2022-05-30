package Cuphead.View;

import Cuphead.App;
import Cuphead.Controller.ColorController;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

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
        App.stage.close();
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
