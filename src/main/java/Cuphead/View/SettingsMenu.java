package Cuphead.View;

import Cuphead.App;
import Cuphead.Controller.ColorController;
import Cuphead.Controller.Controller;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class SettingsMenu {
    public Button grayScale;
    public BorderPane borderPane;
    public ImageView muteIcon;

    public void grayScale(MouseEvent mouseEvent) {
        if (grayScale.getText().equals("GrayScale: Off")){
            grayScale.setText("GrayScale: On");
            ColorController.grayScale = true;
            ColorController.setGrayScale(borderPane);
        }else if (grayScale.getText().equals("GrayScale: On")){
            grayScale.setText("GrayScale: Off");
            ColorController.grayScale = false;
            ColorController.removeGrayScale(borderPane);
        }
    }

    public void initialize(){
        if (ColorController.grayScale){
            ColorController.setGrayScale(borderPane);
        }
        if (!GameMenu.muted)
            muteIcon.setImage(new Image(getClass().getResource("/Cuphead/Images/unmute.png").toExternalForm()));
        else
            muteIcon.setImage(new Image(getClass().getResource("/Cuphead/Images/mute.png").toExternalForm()));
    }

    public void back(MouseEvent mouseEvent) {
        App.changeMenu("MainMenu");
    }

    public void muteGame(MouseEvent mouseEvent) {
        if (GameMenu.muted == false) {
            App.muteMediaPlayer();
            GameMenu.muted = true;
            muteIcon.setImage(new Image(getClass().getResource("/Cuphead/Images/mute.png").toExternalForm()));
        } else {
            App.unmuteMediaPlayer();
            GameMenu.muted = false;
            muteIcon.setImage(new Image(getClass().getResource("/Cuphead/Images/unmute.png").toExternalForm()));
        }
    }

    public void level1(MouseEvent mouseEvent) {
        Controller.getCurrentUser().setHP(10);
        Controller.getCurrentUser().setDamageMultiplier(3);
        Controller.getCurrentUser().setDamageTaken(1);
    }
    public void level2(MouseEvent mouseEvent) {
        Controller.getCurrentUser().setHP(5);
        Controller.getCurrentUser().setDamageMultiplier(2);
        Controller.getCurrentUser().setDamageTaken(2);
    }
    public void level3(MouseEvent mouseEvent) {
        Controller.getCurrentUser().setHP(2);
        Controller.getCurrentUser().setDamageMultiplier(1);
        Controller.getCurrentUser().setDamageTaken(3);
    }
}
