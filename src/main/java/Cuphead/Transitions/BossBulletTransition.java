package Cuphead.Transitions;

import Cuphead.Controller.Controller;
import Cuphead.Controller.GameController;
import Cuphead.Model.BossBullet;
import Cuphead.View.GameMenu;
import javafx.animation.FadeTransition;
import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class BossBulletTransition extends Transition {
    private BossBullet bossBullet;
    private ImageView plane;
    private AnchorPane anchorPane;

    public BossBulletTransition(BossBullet bossBullet, ImageView plane, AnchorPane anchorPane) {
        this.bossBullet = bossBullet;
        this.plane = plane;
        this.anchorPane = anchorPane;
        this.setCycleCount(-1);
        this.setCycleDuration(Duration.millis(500));
    }

    @Override
    protected void interpolate(double v) {
        bossBullet.setX(bossBullet.getX() - 10);
        v *= 7;
        int pos = (int) Math.floor(v);
        bossBullet.setImage(new Image(getClass().getResource("/Cuphead/Images/Bird Bullet/" + pos + ".png").toExternalForm()));
        if (bossBullet.getY() <= plane.getY() + plane.getFitHeight() && bossBullet.getY() + bossBullet.getFitHeight() >= plane.getY()
                && bossBullet.getX() <= plane.getX() + plane.getFitWidth() && !GameMenu.faded){
            anchorPane.getChildren().remove(bossBullet);
            GameController.planeLoseHP(1 * Controller.getCurrentUser().getDamageTaken());
            bossBullet = null;
            this.stop();
            fadePlane();
        }
    }

    private void fadePlane(){
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setNode(plane);
        fadeTransition.setCycleCount(1);
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setFromValue(10);
        fadeTransition.setToValue(0.1);
        GameMenu.faded = true;
        fadeTransition.play();
        fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FadeTransition fadeTransition1 = new FadeTransition();
                fadeTransition1.setNode(plane);
                fadeTransition1.setCycleCount(1);
                fadeTransition1.setDuration(Duration.millis(500));
                fadeTransition1.setFromValue(0.1);
                fadeTransition1.setToValue(10);
                fadeTransition1.play();
                GameMenu.faded = false;
            }
        });
    }
}
