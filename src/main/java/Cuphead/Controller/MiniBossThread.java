package Cuphead.Controller;

import Cuphead.Model.MiniBoss;
import Cuphead.Transitions.MiniBossTransition;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class MiniBossThread implements Runnable{
    private AnchorPane anchorPane;
    private long initialTime;
    private ImageView plane;

    public MiniBossThread(long initialTime, AnchorPane anchorPane, ImageView plane) {
        this.plane = plane;
        this.anchorPane = anchorPane;
        this.initialTime = initialTime;
    }

    @Override
    public void run() {
        while (true){
            if (System.currentTimeMillis() - initialTime >= 6000){
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                            MiniBoss miniBoss1 = new MiniBoss(new Image(getClass().getResource("/Cuphead/Images/Flappy Birds/Yellow/Fly/0.png").toExternalForm()));
                            miniBoss1.setFitWidth(114);
                            miniBoss1.setFitHeight(79);
                            anchorPane.getChildren().add(miniBoss1);
                            MiniBossTransition miniBossTransition1 = new MiniBossTransition(miniBoss1, plane, anchorPane);
                            miniBossTransition1.play();

                            MiniBoss miniBoss2 = new MiniBoss(new Image(getClass().getResource("/Cuphead/Images/Flappy Birds/Yellow/Fly/0.png").toExternalForm()));
                            miniBoss2.setFitWidth(114);
                            miniBoss2.setFitHeight(79);
                            miniBoss2.setX(miniBoss2.getX() + 100);
                            anchorPane.getChildren().add(miniBoss2);
                            MiniBossTransition miniBossTransition2 = new MiniBossTransition(miniBoss2, plane, anchorPane);
                            miniBossTransition2.play();
                    }
                });
                initialTime = System.currentTimeMillis();
            }
        }
    }
}
