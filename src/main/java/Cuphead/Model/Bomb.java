package Cuphead.Model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Bomb extends ImageView {
    private static ArrayList<Bomb> allBombs = new ArrayList<>();
    public Bomb(double x, double y){
        this.setX(x);
        this.setY(y);
        this.setFitWidth(55);
        this.setFitHeight(36);
        this.setImage(new Image(getClass().getResource("/Cuphead/Images/Bomb Bullet/0.png").toExternalForm()));
        allBombs.add(this);
    }

    public static ArrayList<Bomb> getAllBombs() {
        return allBombs;
    }
}
