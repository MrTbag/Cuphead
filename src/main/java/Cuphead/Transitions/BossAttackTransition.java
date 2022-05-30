package Cuphead.Transitions;

import Cuphead.Model.BossHead;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class BossAttackTransition extends Transition {
    private BossHead bossHead;

    public BossAttackTransition(BossHead bossHead) {
        this.bossHead = bossHead;
        this.setCycleCount(1);
        this.setCycleDuration(Duration.millis(2000));
    }

    @Override
    protected void interpolate(double v) {
        v *= 15;
        int pos = (int) Math.floor(v);
        bossHead.setImage(new Image(getClass().getResource("/Cuphead/Images/Barf/" + pos + ".png").toExternalForm()));
    }
}
