package Cuphead.Transitions;

import javafx.animation.Transition;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;

public class RocketProgressbarTransition extends Transition {
    ProgressBar progressBar;

    public RocketProgressbarTransition(ProgressBar progressBar) {
        this.progressBar = progressBar;
        this.setCycleCount(-1);
        this.setCycleDuration(Duration.millis(200));
    }

    @Override
    protected void interpolate(double v) {
        progressBar.setProgress(progressBar.getProgress() + 0.001);
    }
}
