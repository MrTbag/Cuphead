package Cuphead.Model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BossHead extends ImageView {
    public BossHead(Image image) {
        super(image);
        this.setX(900);
        this.setY(250);
        this.setFitWidth(163);
        this.setFitHeight(154);
    }
}
