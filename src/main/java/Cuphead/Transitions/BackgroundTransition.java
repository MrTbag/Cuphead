package Cuphead.Transitions;

import javafx.animation.Transition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class BackgroundTransition extends Transition {
    private ImageView background2;
    private ImageView background3;

    public BackgroundTransition(ImageView background2, ImageView background3) {
        this.background2 = background2;
        this.background3 = background3;
        this.setCycleCount(-1);
        this.setCycleDuration(Duration.millis(100));
    }

    @Override
    protected void interpolate(double v) {
        background2.setX(background2.getX() - 5);
        if (background2.getX() + background2.getFitWidth() <= 0)
            background2.setX(0);
        background3.setX(background3.getX() - 5);
        if (background3.getX() + 1280 <= 0)
            background3.setX(0);
    }
}
