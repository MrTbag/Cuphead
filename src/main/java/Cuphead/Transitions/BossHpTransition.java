package Cuphead.Transitions;

import Cuphead.Controller.Controller;
import Cuphead.Controller.GameController;
import javafx.animation.Transition;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class BossHpTransition extends Transition {
    private Text text;
    private int HP;

    public BossHpTransition(Text text) {
        this.text = text;
        this.setCycleCount(-1);
        this.setCycleDuration(Duration.millis(200));
    }

    @Override
    protected void interpolate(double v) {
        HP = Controller.getCurrentBoss().getHP();
        text.setText("Boss HP: " + HP);
    }
}
