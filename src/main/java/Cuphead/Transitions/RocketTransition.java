package Cuphead.Transitions;

import Cuphead.Controller.Controller;
import Cuphead.Controller.GameController;
import Cuphead.Model.BossHead;
import Cuphead.View.GameMenu;
import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;

public class RocketTransition extends Transition {
    private ImageView plane;
    private BossHead bossHead;
    private AnchorPane anchorPane;
    private IdleTransition idleTransition;
    private BoomTransition boomTransition;

    public RocketTransition(ImageView plane, BossHead bossHead, AnchorPane anchorPane, IdleTransition idleTransition, BoomTransition boomTransition) {
        this.plane = plane;
        this.bossHead = bossHead;
        this.anchorPane = anchorPane;
        this.idleTransition = idleTransition;
        this.boomTransition = boomTransition;
        this.setCycleCount(-1);
        this.setCycleDuration(Duration.millis(1000));
    }

    @Override
    protected void interpolate(double v) {
        v *= 21;
        int pos = (int) Math.floor(v);

        plane.setImage(new Image(getClass().getResource("/Cuphead/Images/Rocket/Turning/" + pos + ".png").toExternalForm()));
        plane.setX(plane.getX() + 5);
        if (plane.getX() >= bossHead.getX()){
            GameController.bossLoseHP(4 * Controller.getCurrentUser().getDamageMultiplier());
            this.stop();
            AudioClip audioClip = new AudioClip(getClass().getResource("/Cuphead/Music/Woopow.m4a").toExternalForm());
            audioClip.play();
            boomTransition.play();
            boomTransition.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    plane.setImage(new Image(getClass().getResource("/Cuphead/Images/Idle/0.png").toExternalForm()));
                    plane.setX(50);
                    plane.setY(300);
                    idleTransition.play();
                }
            });

        }else if (plane.getX() >= 1200){
        }

    }
}
