package Cuphead.Transitions;

import javafx.animation.Transition;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class TimerTransition extends Transition {
    private Text text;
    private long initialTime = System.currentTimeMillis();

    public TimerTransition(Text text) {
        this.text = text;
        this.setCycleCount(-1);
        this.setCycleDuration(Duration.millis(200));
    }

    @Override
    protected void interpolate(double v) {
        long minutes = (System.currentTimeMillis() - initialTime)/1000;
        minutes /= 60;
        long seconds = (System.currentTimeMillis() - initialTime)/1000 - minutes*60;
        text.setText(minutes + ":" + seconds);
    }
}
