package Cuphead.Controller;

import Cuphead.Model.Boss;
import Cuphead.Model.User;

public class Controller {
    protected static User currentUser = null;
    protected static Boss currentBoss = null;

    public static void setCurrentUser(User user){
        Controller.currentUser = user;
    }

    public void setCurrentBoss(Boss boss){
        Controller.currentBoss = boss;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static Boss getCurrentBoss() {
        return currentBoss;
    }
}
