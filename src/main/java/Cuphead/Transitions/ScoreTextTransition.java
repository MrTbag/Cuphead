package Cuphead.Transitions;

import Cuphead.Controller.Controller;
import javafx.animation.Transition;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class ScoreTextTransition extends Transition {
    private int score = 0;
    private Text text;

    public ScoreTextTransition(Text text) {
        this.text = text;
        this.setCycleCount(-1);
        this.setCycleDuration(Duration.millis(100));
    }

    @Override
    protected void interpolate(double v) {
        text.setText("Score: " + score);
        score = Controller.getCurrentUser().getScore();
    }
}
