package Cuphead.Transitions;

import Cuphead.Controller.Controller;
import javafx.animation.Transition;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;

public class BossHpProgressbarTransition extends Transition {
    private ProgressBar progressBar;

    public BossHpProgressbarTransition(ProgressBar progressBar) {
        this.progressBar = progressBar;
        this.setCycleCount(-1);
        this.setCycleDuration(Duration.millis(200));
    }

    @Override
    protected void interpolate(double v) {
        double pr = (double) Controller.getCurrentBoss().getHP() * 0.01;
        this.progressBar.setProgress(pr);
    }
}
