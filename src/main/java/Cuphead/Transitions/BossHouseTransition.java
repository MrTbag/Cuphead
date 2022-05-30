package Cuphead.Transitions;

import Cuphead.Model.BossHouse;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class BossHouseTransition extends Transition {
    private BossHouse bossHouse;
    public BossHouseTransition(BossHouse bossHouse) {
        this.bossHouse = bossHouse;
        this.setCycleCount(-1);
        this.setCycleDuration(Duration.millis(1000));
    }

    @Override
    protected void interpolate(double v) {
        v *= 16;
        int pos = (int) Math.floor(v);
        this.bossHouse.setImage(new Image(getClass().getResource("/Cuphead/Images/House/" + pos + ".png").toExternalForm()));
    }
}
