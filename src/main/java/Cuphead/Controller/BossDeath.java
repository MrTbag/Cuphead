package Cuphead.Controller;



public class BossDeath extends Thread{

    @Override
    public void run(){
        if (GameController.getCurrentBoss().getHP() == 0)
            System.out.println("WOW");
    }
}
