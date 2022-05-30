package Cuphead.Controller;

public class GameController extends Controller{
    public static void planeLoseHP(int HP){
        currentUser.setHP(currentUser.getHP() - HP);
    }

    public static void bossLoseHP(int HP){
        currentBoss.setHP(currentBoss.getHP() - HP);
    }
}
