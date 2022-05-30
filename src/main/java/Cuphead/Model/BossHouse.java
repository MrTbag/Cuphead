package Cuphead.Model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BossHouse extends ImageView {
    public BossHouse (Image image){
        super(image);
        this.setX(950);
        this.setY(170);
        this.setFitWidth(351);
        this.setFitHeight(229);
    }
}
