package Cuphead.Transitions;

import Cuphead.Controller.Controller;
import Cuphead.Controller.GameController;
import Cuphead.Model.BossHead;
import Cuphead.View.GameMenu;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.AudioSpectrumListener;
import javafx.util.Duration;

public class BossHeadTransition extends Transition {
    private BossHead bossHead;
    private AnchorPane anchorPane;

    public BossHeadTransition(BossHead bossHead, AnchorPane anchorPane){
        this.bossHead = bossHead;
        this.anchorPane = anchorPane;
        this.setCycleCount(-1);
        this.setCycleDuration(Duration.millis(500));
    }

    @Override
    protected void interpolate(double v) {
        v *= 16;
        int pos = (int) Math.floor(v);
        if (this.bossHead != null){
            this.bossHead.setImage(new Image(getClass().getResource("/Cuphead/Images/Head/Idle/" + pos + ".png").toExternalForm()));
            if (GameController.getCurrentBoss().getHP() <= 0){
                if (!GameMenu.muted){
                    AudioClip audioClip = new AudioClip(getClass().getResource("/Cuphead/Music/Scream.mp3").toExternalForm());
                    audioClip.play();
                }
                anchorPane.getChildren().remove(bossHead);
                Controller.getCurrentUser().setScore(Controller.getCurrentUser().getScore() + 100);
                bossHead = null;
                this.stop();
                this.setCycleCount(0);
            }
        }
    }
}
