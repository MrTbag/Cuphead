package Cuphead.Transitions;

import Cuphead.Controller.GameController;
import javafx.animation.Transition;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class UserHpTransition extends Transition {
    private Text text;
    private int HP;

    public UserHpTransition(Text text) {
        this.text = text;
        this.setCycleCount(-1);
        this.setCycleDuration(Duration.millis(100));
    }

    @Override
    protected void interpolate(double v) {
        HP = GameController.getCurrentUser().getHP();
        text.setText("HP: " + HP);
        if (HP == 1)
            text.setFill(new Color(1, 0, 0, 1));
    }
}
