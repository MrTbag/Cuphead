package Cuphead.Transitions;

import Cuphead.Model.MiniBoss;
import javafx.animation.Transition;
import javafx.scene.image.Image;

public class MiniBossTransition extends Transition {
    private MiniBoss miniBoss;

    public MiniBossTransition(MiniBoss miniBoss) {
        this.miniBoss = miniBoss;
    }

    @Override
    protected void interpolate(double v) {
        v *= 15;
        int pos = (int) Math.floor(v);
        miniBoss.setImage(new Image(getClass().getResource("Cuphead/Images/Flappy Birds/Yellow/Fly/" + pos + ".png").toExternalForm()));
        miniBoss.setX(miniBoss.getX() - 5);
    }
}
