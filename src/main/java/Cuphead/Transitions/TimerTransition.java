package Cuphead.Transitions;

import javafx.animation.Transition;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.text.DecimalFormat;

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
        DecimalFormat decimalFormat = new DecimalFormat("00");

        long minutes = (System.currentTimeMillis() - initialTime)/1000;
        minutes /= 60;
        long seconds = (System.currentTimeMillis() - initialTime)/1000 - minutes*60;
        text.setText(decimalFormat.format(minutes) + ":" + decimalFormat.format(seconds));
    }
}
