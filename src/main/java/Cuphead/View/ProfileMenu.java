package Cuphead.View;

import Cuphead.App;
import Cuphead.Controller.ColorController;
import Cuphead.Controller.Controller;
import Cuphead.Controller.GameController;
import Cuphead.Controller.ProfileController;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class ProfileMenu {
    public TextField username;
    public TextField password;
    public Text warning;
    public ImageView character0;
    public ImageView character1;
    public ImageView character2;
    public ImageView character3;
    public ImageView character4;
    public BorderPane borderPane;

    ProfileController profileController = new ProfileController();

    public void logout(MouseEvent mouseEvent) {
        profileController.logout();
        App.changeMenu("LoginMenu");
    }

    public void changeUsername(MouseEvent mouseEvent) {
        if (username.getText().equals(""))
            warning.setText("Username can't be empty");
        else
            warning.setText(profileController.changeUsername(username.getText()));
    }

    public void changePassword(MouseEvent mouseEvent) {
        if (password.getText().equals(""))
            warning.setText("Password can't be empty");
        else
            warning.setText(profileController.changePassword(password.getText()));
    }

    public void deleteAccount(MouseEvent mouseEvent) {
        warning.setText(profileController.deleteAccount());
        App.changeMenu("LoginMenu");
    }

    public void chooseAvatar(MouseEvent mouseEvent) {
        Object source = mouseEvent.getSource();
        if (character0.equals(source)) {
            GameController.getCurrentUser().setAvatar(0);
        } else if (character1.equals(source)) {
            GameController.getCurrentUser().setAvatar(1);
        } else if (character2.equals(source)) {
            GameController.getCurrentUser().setAvatar(2);
        } else if (character3.equals(source)) {
            GameController.getCurrentUser().setAvatar(3);
        } else if (character4.equals(source)) {
            GameController.getCurrentUser().setAvatar(4);
        }
    }

    public void initialize(){
        character0.setImage(new Image(getClass().getResource("/Cuphead/Images/Avatar/0.png").toExternalForm()));
        character1.setImage(new Image(getClass().getResource("/Cuphead/Images/Avatar/1.png").toExternalForm()));
        character2.setImage(new Image(getClass().getResource("/Cuphead/Images/Avatar/2.png").toExternalForm()));
        character3.setImage(new Image(getClass().getResource("/Cuphead/Images/Avatar/3.png").toExternalForm()));
        character4.setImage(new Image(getClass().getResource("/Cuphead/Images/Avatar/4.png").toExternalForm()));
        GameController.getCurrentUser().setAvatar(0);
        if (ColorController.grayScale){
            ColorController.setGrayScale(borderPane);
        }
    }

}
