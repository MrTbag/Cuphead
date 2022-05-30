package Cuphead.View;

import Cuphead.App;
import Cuphead.Controller.ColorController;
import Cuphead.Controller.Controller;
import Cuphead.Controller.GameController;
import Cuphead.Controller.LoginController;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;

public class LoginMenu {
    public BorderPane borderPane;
    LoginController loginController = new LoginController();

    public TextField username;
    public TextField password;
    public Text warning;

    public void register(MouseEvent mouseEvent) throws FileNotFoundException {
        warning.setText(loginController.register(username.getText(), password.getText()));
    }

    public void login(MouseEvent mouseEvent) throws Exception {
        String text = loginController.login(username.getText(), password.getText());
        warning.setText(text);
        if (text.equals("Logged in successfully")){
            App.changeMenu("MainMenu");
        }
    }

    public void playAsGuest(MouseEvent mouseEvent) {
        warning.setText(loginController.playAsGuest());
        App.changeMenu("GameMenu");
        App.setMediaPlayer();
    }

    public void initialize(){
        if (ColorController.grayScale){
            ColorController.setGrayScale(borderPane);
        }
    }
}
