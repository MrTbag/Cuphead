package Cuphead.Controller;

import Cuphead.Model.BossBullet;
import Cuphead.Model.BossHead;
import Cuphead.Model.MiniBoss;
import Cuphead.Transitions.BossAttackTransition;
import Cuphead.Transitions.BossBulletTransition;
import Cuphead.Transitions.MiniBossTransition;
import javafx.animation.Transition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class BossBulletThread implements Runnable {
    private BossHead bossHead;
    private AnchorPane anchorPane;
    private long initialTime;
    private ImageView plane;

    public BossBulletThread(long initialTime, AnchorPane anchorPane, BossHead bossHead, ImageView plane) {
        this.bossHead = bossHead;
        this.anchorPane = anchorPane;
        this.initialTime = initialTime;
        this.plane = plane;
    }

    @Override
    public void run() {
        while (true){
            if (System.currentTimeMillis() - initialTime >= 3000){
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        BossAttackTransition bossAttackTransition = new BossAttackTransition(bossHead);
                        bossAttackTransition.play();
                        BossBullet bossBullet = new BossBullet(850, 300);
                        anchorPane.getChildren().add(bossBullet);
                        BossBulletTransition bossBulletTransition = new BossBulletTransition(bossBullet, plane, anchorPane);
                        bossAttackTransition.setOnFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                bossBulletTransition.play();
                            }
                        });
                    }
                });
                initialTime = System.currentTimeMillis();
            }
        }
    }
}
