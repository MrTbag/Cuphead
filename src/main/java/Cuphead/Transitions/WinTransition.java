package Cuphead.Transitions;

import javafx.animation.Transition;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class WinTransition extends Transition {
    private Text text;

    public WinTransition(Text text) {
        this.text = text;
        this.setCycleCount(1);
        this.setCycleDuration(Duration.millis(3000));
    }

    @Override
    protected void interpolate(double frac) {

    }
}
