package Cuphead.Transitions;

import javafx.animation.Transition;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class RocketIntroTransition extends Transition {
    private ImageView plane;

    public RocketIntroTransition(ImageView plane) {
        this.plane = plane;
        this.setCycleCount(1);
        this.setCycleDuration(Duration.millis(1000));
    }

    @Override
    protected void interpolate(double v) {
        v *= 13;
        int pos = (int) Math.floor(v);
        plane.setImage(new Image(getClass().getResource("/Cuphead/Images/Rocket/Intro/" + pos + ".png").toExternalForm()));
    }
}
