package Cuphead.Transitions;

import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class IdleTransition extends Transition {
    private ImageView imageView;

    public IdleTransition(ImageView imageView) {
        this.imageView = imageView;
        this.setCycleDuration(Duration.millis(200));
        this.setCycleCount(-1);
        this.setAutoReverse(true);
    }

    @Override
    protected void interpolate(double v) {
        v *= 11;
        int pos = (int) Math.floor(v);
        this.imageView.setImage(new Image(getClass().getResource("/Cuphead/Images/Idle/" + pos + ".png").toExternalForm()));
    }
}
