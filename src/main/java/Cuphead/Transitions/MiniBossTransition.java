package Cuphead.Transitions;

import Cuphead.Controller.Controller;
import Cuphead.Controller.GameController;
import Cuphead.Model.MiniBoss;
import Cuphead.View.GameMenu;
import javafx.animation.FadeTransition;
import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class MiniBossTransition extends Transition {
    private MiniBoss miniBoss;
    private ImageView plane;
    private AnchorPane anchorPane;

    public MiniBossTransition(MiniBoss miniBoss, ImageView plane, AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
        this.miniBoss = miniBoss;
        this.plane = plane;
        this.setCycleCount(-1);
        this.setCycleDuration(Duration.millis(500));
    }

    @Override
    protected void interpolate(double v) {
        v *= 15;
        int pos = (int) Math.floor(v);
        if (miniBoss != null){
            miniBoss.setImage(new Image(getClass().getResource("/Cuphead/Images/Flappy Birds/Yellow/Fly/" + pos + ".png").toExternalForm()));
            miniBoss.setX(miniBoss.getX() - 5);
            if (miniBoss.getX() <= 0){
                MiniBoss.getAllMiniBosses().remove(miniBoss);
                anchorPane.getChildren().remove(miniBoss);
                miniBoss = null;
            }else if(miniBoss.getY() >= plane.getY() + plane.getFitHeight() && miniBoss.getY() + miniBoss.getFitHeight() <= miniBoss.getY()
                    && miniBoss.getX() <= plane.getX() + plane.getFitWidth() && !GameMenu.faded){
                MiniBoss.getAllMiniBosses().remove(miniBoss);
                GameController.planeLoseHP(1 * Controller.getCurrentUser().getDamageTaken());
                fadePlane();
                anchorPane.getChildren().remove(miniBoss);
                miniBoss = null;
            }
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
