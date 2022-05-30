package Cuphead.Transitions;

import Cuphead.Controller.CollisionController;
import Cuphead.Controller.Controller;
import Cuphead.Controller.GameController;
import Cuphead.Model.Bomb;
import Cuphead.Model.BossHead;
import Cuphead.Model.Bullet;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class BombTransition extends Transition {
    private Bomb bomb;
    private AnchorPane anchorPane;
    private BossHead bossHead;
    private CollisionController collisionController = new CollisionController();

    public BombTransition(Bomb bomb, AnchorPane anchorPane, BossHead bossHead) {
        this.bossHead = bossHead;
        this.bomb = bomb;
        this.anchorPane = anchorPane;
        this.setCycleCount(-1);
        this.setCycleDuration(Duration.millis(500));
    }

    @Override
    protected void interpolate(double v) {
        v *= 6;
        int pos = (int) Math.floor(v);
        if (this.bomb != null){
            this.bomb.setImage(new Image(getClass().getResource("/Cuphead/Images/Bomb Bullet/" + pos + ".png").toExternalForm()));
            this.bomb.setX(this.bomb.getX() + 10);
            this.bomb.setY(this.bomb.getY() + 5);
            if (this.bomb.getX() >= 1200 || this.bomb.getY() >= 700){
                Bomb.getAllBombs().remove(bomb);
                anchorPane.getChildren().remove(bomb);
                bomb = null;
                this.stop();
                this.setCycleCount(0);
            }else if (collisionController.doesBombHitBoss(bomb, bossHead)){
                GameController.getCurrentUser().setScore(GameController.getCurrentUser().getScore() + 15);
                Bomb.getAllBombs().remove(bomb);
                anchorPane.getChildren().remove(bomb);
                bomb = null;
                GameController.bossLoseHP(2 * Controller.getCurrentUser().getDamageMultiplier());
                this.stop();
                this.setCycleCount(0);
            }

        }
    }
}
