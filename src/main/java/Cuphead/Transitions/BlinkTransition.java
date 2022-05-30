package Cuphead.Transitions;

import javafx.animation.FadeTransition;
import javafx.animation.Transition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class BlinkTransition extends Transition {
    private ImageView plane;

    public BlinkTransition(ImageView plane) {
        this.plane = plane;
        this.setCycleCount(1);
        this.setCycleDuration(Duration.millis(500));
        this.setAutoReverse(true);
    }

    @Override
    protected void interpolate(double v) {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setNode(plane);
    }
}
