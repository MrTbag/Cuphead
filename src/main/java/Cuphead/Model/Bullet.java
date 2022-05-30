package Cuphead.Model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Bullet extends ImageView {
    private static ArrayList<Bullet> allBullets = new ArrayList<>();

    public Bullet(double x, double y, Image image) {
        super(image);
        this.setX(x);
        this.setY(y);
        this.setFitWidth(101);
        this.setFitHeight(19);
        allBullets.add(this);
    }

    public static ArrayList<Bullet> getAllBullets() {
        return allBullets;
    }
}
