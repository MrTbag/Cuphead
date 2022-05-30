package Cuphead.Transitions;

import Cuphead.Controller.CollisionController;
import Cuphead.Controller.Controller;
import Cuphead.Controller.GameController;
import Cuphead.Model.BossHead;
import Cuphead.Model.Bullet;
import Cuphead.Model.MiniBoss;
import Cuphead.View.GameMenu;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.util.ConcurrentModificationException;

public class BulletTransition extends Transition {
    private Bullet bullet;
    private AnchorPane anchorPane;
    private BossHead bossHead;
    private CollisionController collisionController = new CollisionController();

    public BulletTransition(Bullet bullet, AnchorPane anchorPane, BossHead bossHead) {
        this.setCycleCount(-1);
        this.setCycleDuration(Duration.millis(50));
        this.bullet = bullet;
        this.anchorPane = anchorPane;
        this.bossHead = bossHead;
    }

    @Override
    protected void interpolate(double v){
        v *= 8;
        int pos = (int) Math.floor(v);
        if (bullet != null){
            this.bullet.setX(this.bullet.getX() + 5);
            this.bullet.setImage(new Image(getClass().getResource("/Cuphead/Images/Bullet/" + pos + ".png").toExternalForm()));
            if (this.bullet.getX() >= 1180){
                Bullet.getAllBullets().remove(bullet);
                anchorPane.getChildren().remove(bullet);
                bullet = null;
                this.setCycleCount(0);
            }else if (collisionController.doesBulletHitBoss(bullet, bossHead)){
                GameController.getCurrentUser().setScore(GameController.getCurrentUser().getScore() + 5);
                Bullet.getAllBullets().remove(bullet);
                anchorPane.getChildren().remove(bullet);
                bullet = null;
                GameController.bossLoseHP(1 * Controller.getCurrentUser().getDamageMultiplier());
                this.setCycleCount(0);
            }else{
                for (MiniBoss miniBoss : MiniBoss.getAllMiniBosses()) {
                    if (bullet.getX() + bullet.getFitWidth() >= miniBoss.getX()){
                        GameController.getCurrentUser().setScore(GameController.getCurrentUser().getScore() + 5);
                        Bullet.getAllBullets().remove(bullet);
                        anchorPane.getChildren().remove(bullet);
                        bullet = null;
                        MiniBoss.getAllMiniBosses().remove(miniBoss);
                        anchorPane.getChildren().remove(miniBoss);
                        miniBoss = null;
                        this.setCycleCount(0);
                        break;
                    }
                }
            }
        }
    }
}
