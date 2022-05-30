package Cuphead.Model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Plane extends ImageView {
    private int HP;

    public Plane(){
        this.setImage(new Image(getClass().getResource("/Cuphead/Images/plane.png").toExternalForm()));
        this.setX(200);
        this.setY(300);
        this.setFitWidth(113);
        this.setFitHeight(98);
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }
}
