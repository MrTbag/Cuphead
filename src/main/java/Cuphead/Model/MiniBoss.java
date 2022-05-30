package Cuphead.Model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class MiniBoss extends ImageView {
    private static ArrayList<MiniBoss> allMiniBosses = new ArrayList<>();

    public MiniBoss(Image image) {
        super(image);
        this.setX(1280);
        this.setY(300);
        this.setFitWidth(163);
        this.setFitHeight(154);
        allMiniBosses.add(this);
    }

    public static ArrayList<MiniBoss> getAllMiniBosses() {
        return allMiniBosses;
    }
}
