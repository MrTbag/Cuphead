package Cuphead.Controller;

import Cuphead.Model.User;

import java.util.Collections;

public class UserController extends Controller{
    public static void sortUsers(){
        for (int i = 0; i < User.getAllUsers().size(); i++) {
            for (int j = 0; j < i; j++) {
                if (User.getAllUsers().get(j).getScore() <= User.getAllUsers().get(i).getScore()){
                    User tmp = User.getAllUsers().get(i);
                    User.getAllUsers().remove(i);
                    User.getAllUsers().add(i, User.getAllUsers().get(j));
                    User.getAllUsers().remove(j);
                    User.getAllUsers().add(j, tmp);
                }
            }
        }
    }

    public static void printUsers(){
        for (User user : User.getAllUsers()) {
            System.out.println(user.getUsername());
        }
    }

}
