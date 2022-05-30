package Cuphead.View;

import Cuphead.Controller.ColorController;
import Cuphead.Controller.UserController;
import Cuphead.Model.User;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ScoreBoard {

    public BorderPane borderPane;

    public void initialize(){
        if (ColorController.grayScale){
            ColorController.setGrayScale(borderPane);
        }
        int cnt = 0;
        UserController.sortUsers();
        for (User user : User.getAllUsers()) {
            if(cnt++ < 10){
                Label label = new Label(user.getUsername() + ":  " + user.getScore());
                if (cnt == 1)
                    label.setStyle("-fx-background-color: gold");
                if (cnt == 2)
                    label.setStyle("-fx-background-color: #949494");
                if (cnt == 3)
                    label.setStyle("-fx-background-color: #654b12");
                VBox vBox = (VBox) borderPane.getChildren().get(0);
                vBox.getChildren().add(label);
            }
        }
    }
}
