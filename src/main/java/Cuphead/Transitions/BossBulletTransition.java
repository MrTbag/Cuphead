package Cuphead.Transitions;

import Cuphead.Model.BossBullet;
import javafx.animation.Transition;
import javafx.scene.image.Image;

public class BossBulletTransition extends Transition {
    private BossBullet bossBullet;

    public BossBulletTransition(BossBullet bossBullet) {
        this.bossBullet = bossBullet;
    }

    @Override
    protected void interpolate(double v) {
        bossBullet.setX(bossBullet.getX() - 10);
        v *= 7;
        int pos = (int) Math.floor(v);
        bossBullet.setImage(new Image(getClass().getResource("/Cuphead/Images/Bird Bullet/" + pos + ".png").toExternalForm()));
    }
}
