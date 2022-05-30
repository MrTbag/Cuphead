package Cuphead.Controller;

import Cuphead.Model.MiniBoss;
import Cuphead.Transitions.MiniBossTransition;
import Cuphead.View.GameMenu;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

public class Time implements Runnable{
    private AnchorPane anchorPane;
    private long initialTime;

    public Time(long initialTime, AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
        this.initialTime = initialTime;
    }

    @Override
    public void run() {
        while (true){
            if (System.currentTimeMillis() - initialTime >= 4000){
                GameMenu.miniBossAttack = true;

                initialTime = System.currentTimeMillis();
            }
        }
    }
}
