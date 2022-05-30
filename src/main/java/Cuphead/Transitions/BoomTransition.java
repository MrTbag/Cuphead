package Cuphead.Transitions;

import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class BoomTransition extends Transition {
    private ImageView plane;

    public BoomTransition(ImageView plane) {
        this.plane = plane;
        this.setCycleCount(1);
        this.setCycleDuration(Duration.millis(1000));
    }

    @Override
    protected void interpolate(double v) {
        v *= 10;
        int pos = (int) Math.floor(v);
        plane.setImage(new Image(getClass().getResource("/Cuphead/Images/Rocket/Boom/" + pos + ".png").toExternalForm()));
    }
}
