package Cuphead.Controller;

import Cuphead.Model.Bomb;
import Cuphead.Model.BossHead;
import Cuphead.Model.Bullet;
import Cuphead.View.GameMenu;
import javafx.scene.image.ImageView;

import java.nio.Buffer;

public class CollisionController {

    public boolean doesPlaneHitTop(ImageView imageView) {
        return imageView.getY() <= 0;
    }

    public boolean doesPlaneHitBottom(ImageView imageView) {
        return imageView.getY() + imageView.getFitHeight() >= 720;
    }

    public boolean doesPlaneHitLeft(ImageView imageView) {
        return imageView.getX() <= 0;
    }

    public boolean doesPlaneHitRight(ImageView imageView) {
        return imageView.getX() + imageView.getFitWidth() >= 1280;
    }

    public boolean doesBulletHitBoss(Bullet bullet, BossHead bossHead) {
        return bullet.getX() + bullet.getFitWidth() >= bossHead.getX() &&
                (bullet.getY() <= bossHead.getY() + bossHead.getFitHeight() && bullet.getY() +
                        bullet.getFitHeight() >= bossHead.getY());
    }

    public boolean doesBombHitBoss(Bomb bomb, BossHead bossHead) {
        return bomb.getX() + bomb.getFitWidth() >= bossHead.getX() &&
                (bomb.getY() <= bossHead.getY() + bossHead.getFitHeight() && bomb.getY() +
                        bomb.getFitHeight() >= bossHead.getY());
    }

    public boolean doesPlaneHitBoss(ImageView plane, ImageView boss) {
        return (plane.getX() + plane.getFitWidth() >= boss.getX()) && (plane.getY() + plane.getFitHeight() >= boss.getY())
                && (plane.getY() <= boss.getY() + boss.getFitHeight()) && !GameMenu.faded;
    }
}