package Cuphead.Model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BossBullet extends ImageView {

    public BossBullet(double x, double y) {
        super();
        this.setX(x);
        this.setY(y);
        this.setFitWidth(101);
        this.setFitHeight(19);
    }
}
