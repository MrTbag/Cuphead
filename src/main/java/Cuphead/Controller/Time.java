package Cuphead.Controller;

import Cuphead.Model.MiniBoss;
import Cuphead.Transitions.MiniBossTransition;
import Cuphead.View.GameMenu;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

public class Time implements Runnable{
    private long startTime;
    private AnchorPane anchorPane;

    public Time(long startTime, AnchorPane anchorPane) {
        this.startTime = startTime;
        this.anchorPane = anchorPane;
    }

    @Override
    public void run() {
        while (true){
            if (System.currentTimeMillis() - startTime >= 4000){
//                Platform.runLater(new Runnable() {
//                    @Override
//                    public void run() {
//                        MiniBoss miniBoss = new MiniBoss(new Image(getClass().getResource(
//                                "/Cuphead/Images/Flappy Birds/Yellow/Fly/0.png").toExternalForm()));
//                        miniBoss.setX(1280);
//                        miniBoss.setY(300);
//                        anchorPane.getChildren().add(miniBoss);
//                        MiniBossTransition miniBossTransition = new MiniBossTransition(miniBoss);
//                        miniBossTransition.play();
//                    }
//                });
                startTime = System.currentTimeMillis();
                System.out.println("naneye zarrabi");
            }
        }
    }
}
