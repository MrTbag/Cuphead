package Cuphead.Model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MiniBoss extends ImageView {

    public MiniBoss(Image image) {
        super(image);
        this.setX(1280);
        this.setY(300);
        this.setFitWidth(163);
        this.setFitHeight(154);
    }
}
