package Cuphead.View;

import Cuphead.App;
import Cuphead.Controller.*;
import Cuphead.Model.*;
import Cuphead.Transitions.*;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class GameMenu {
    public ImageView plane;
    public AnchorPane anchorPane;
    public Boss boss;
    public BossHead bossHead;
    public BossHouse bossHouse;
    public ImageView fireMode;
    public int FireMode = 0;
    public static boolean muted = false;
    public ImageView muteIcon;
    public IdleTransition idleTransition;
    public BoomTransition boomTransition;
    public ImageView avatar;
    public ImageView background1;
    public ImageView background2;
    public ImageView background3;
    public int pause = 0;
    public BackgroundTransition backgroundTransition;
    public Text scoreText;
    ScoreTextTransition scoreTextTransition;
    public Text hpText;
    public static boolean faded = false;
    public ProgressBar rocketProgressbar;
    public RocketProgressbarTransition rocketProgressbarTransition;
    public long bossAttackTime;
    public static boolean bossAttack = false;
    public Text bossHpText;
    public BossHpTransition bossHpTransition;
    public UserHpTransition userHpTransition;
    public ProgressBar bossHpProgressBar;
    public BossHpProgressbarTransition bossHpProgressbarTransition;
    public BossBullet bossBullet;
    public BossBulletTransition bossBulletTransition;
    public TimerTransition timerTransition;
    public Text timeText;
    public static boolean miniBossAttack = false;
    Controller controller = new Controller();
    CollisionController collisionController = new CollisionController();

    public void controlPlane(KeyEvent keyEvent) throws InterruptedException {
        switch (keyEvent.getCode().getName()) {
            case ("Up"):
                if (!collisionController.doesPlaneHitTop(plane))
                    plane.setY(plane.getY() - 10);
                if (collisionController.doesPlaneHitBoss(plane, bossHead)){
                    GameController.planeLoseHP(1 * Controller.getCurrentUser().getDamageTaken());
                    if (Controller.getCurrentUser().getHP() <= 0){
                        youLose();
                    }
                    fadePlane();
                }
                break;
            case ("Down"):
                if (!collisionController.doesPlaneHitBottom(plane))
                    plane.setY(plane.getY() + 10);
                if (collisionController.doesPlaneHitBoss(plane, bossHead)){
                    GameController.planeLoseHP(1 * Controller.getCurrentUser().getDamageTaken());
                    if (Controller.getCurrentUser().getHP() <= 0){
                        youLose();
                    }
                    fadePlane();;
                }
                break;
            case ("Left"):
                if (!collisionController.doesPlaneHitLeft(plane))
                    plane.setX(plane.getX() - 10);
                if (collisionController.doesPlaneHitBoss(plane, bossHead)){
                    GameController.planeLoseHP(1 * Controller.getCurrentUser().getDamageTaken());
                    if (Controller.getCurrentUser().getHP() <= 0){
                        youLose();
                    }
                    fadePlane();
                }
                break;
            case ("Right"):
                if (!collisionController.doesPlaneHitRight(plane))
                    plane.setX(plane.getX() + 10);
                if (collisionController.doesPlaneHitBoss(plane, bossHead)){
                    GameController.planeLoseHP(1 * Controller.getCurrentUser().getDamageTaken());
                    if (Controller.getCurrentUser().getHP() <= 0){
                        youLose();
                    }
                    fadePlane();
                }
                break;
            case ("W"):
                if (!collisionController.doesPlaneHitTop(plane))
                    plane.setY(plane.getY() - 10);
                if (collisionController.doesPlaneHitBoss(plane, bossHead)){
                    GameController.planeLoseHP(1 * Controller.getCurrentUser().getDamageTaken());
                    if (Controller.getCurrentUser().getHP() <= 0){
                        youLose();
                    }
                    fadePlane();
                }
                break;
            case ("S"):
                if (!collisionController.doesPlaneHitBottom(plane))
                    plane.setY(plane.getY() + 10);
                if (collisionController.doesPlaneHitBoss(plane, bossHead)){
                    GameController.planeLoseHP(1 * Controller.getCurrentUser().getDamageTaken());
                    if (Controller.getCurrentUser().getHP() <= 0){
                        youLose();
                    }
                    fadePlane();;
                }
                break;
            case ("A"):
                if (!collisionController.doesPlaneHitLeft(plane))
                    plane.setX(plane.getX() - 10);
                if (collisionController.doesPlaneHitBoss(plane, bossHead)){
                    GameController.planeLoseHP(1 * Controller.getCurrentUser().getDamageTaken());
                    if (Controller.getCurrentUser().getHP() <= 0){
                        youLose();
                    }
                    fadePlane();
                }
                break;
            case ("D"):
                if (!collisionController.doesPlaneHitRight(plane))
                    plane.setX(plane.getX() + 10);
                if (collisionController.doesPlaneHitBoss(plane, bossHead)){
                    GameController.planeLoseHP(1 * Controller.getCurrentUser().getDamageTaken());
                    if (Controller.getCurrentUser().getHP() <= 0){
                        youLose();
                    }
                    fadePlane();
                }
                break;
            case ("Space"):
                if (FireMode == 0) {
                    if (!muted) {
                        AudioClip audioClip = new AudioClip(getClass().getResource("/Cuphead/Music/Manam.m4a").toExternalForm());
                        audioClip.play();
                    }
                    Image bulletImage = new Image(getClass().getResource("/Cuphead/Images/Bullet/0.png").toExternalForm());
                    Bullet bullet = new Bullet(plane.getX() + plane.getFitWidth(), plane.getY() + plane.getFitHeight() / 2, bulletImage);
                    anchorPane.getChildren().add(bullet);
                    BulletTransition bulletTransition = new BulletTransition(bullet, anchorPane, bossHead);
                    bulletTransition.play();
                } else {
                    if (!muted) {
                        AudioClip audioClip = new AudioClip(getClass().getResource("/Cuphead/Music/Boom.m4a").toExternalForm());
                        audioClip.play();
                    }
                    Bomb bomb = new Bomb(plane.getX() + plane.getFitWidth(), plane.getY() + plane.getFitHeight());
                    anchorPane.getChildren().add(bomb);
                    BombTransition bombTransition = new BombTransition(bomb, anchorPane, bossHead);
                    bombTransition.play();
                }
                break;
            case ("Tab"):
                if (FireMode == 0)
                    fireMode.setImage(new Image(getClass().getResource("/Cuphead/Images/Bomb Bullet/Icon.png").toExternalForm()));
                else
                    fireMode.setImage(new Image(getClass().getResource("/Cuphead/Images/Bullet/Icon.png").toExternalForm()));
                FireMode = 1 - FireMode;
                break;
            case ("R"):
                if (rocketProgressbar.getProgress() >= 1){
                    idleTransition.stop();
                    RocketIntroTransition rocketIntroTransition = new RocketIntroTransition(plane);
                    rocketIntroTransition.play();
                    boomTransition = new BoomTransition(plane);
                    RocketTransition rocketTransition = new RocketTransition(plane, bossHead, anchorPane, idleTransition, boomTransition);
                    rocketIntroTransition.setOnFinished(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            rocketTransition.play();
                        }
                    });
                    rocketProgressbar.setProgress(0);
                }
                break;
            case ("E"):
                if (pause == 0) {
                    synchronized (this) {
                        pause = 1;
                        System.out.println("1");
                    }
                } else {
                    pause = 0;
                    notify();
                }
        }
    }

    public void initialize() throws InterruptedException {
        if (ColorController.grayScale) {
            ColorController.setGrayScale(anchorPane);
        }
        makeNodes();
        addChildren();
        startTransitions();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                if (miniBossAttack){

                }
            }
        });
//        bossAttackTime = System.currentTimeMillis();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true){
//                    if (System.currentTimeMillis() - bossAttackTime >= 5000){
//                        bossAttackTime = System.currentTimeMillis();
//                        Platform.runLater(new Runnable() {
//                            @Override
//                            public void run() {
//                                BossAttackTransition bossAttackTransition = new BossAttackTransition(bossHead);
//                                bossAttackTransition.play();
//                                bossBullet = new BossBullet(850, 250);
//                                anchorPane.getChildren().add(bossBullet);
//                                bossBulletTransition = new BossBulletTransition(bossBullet);
//                                bossAttackTransition.setOnFinished(new EventHandler<ActionEvent>() {
//                                    @Override
//                                    public void handle(ActionEvent actionEvent) {
//                                        bossBulletTransition.play();
//                                    }
//                                });
//                            }
//                        });
//                    }
//
//                }
//            }
//        }).start();
        Thread flappy = new Thread(new Time(System.currentTimeMillis(), anchorPane));
        flappy.setDaemon(true);
        flappy.start();
//        Platform.runLater(new Runnable() {
//            @Override
//            public void run() {
//                if (!miniBossAttack){
//                    System.out.println("wow");
//                    MiniBoss miniBoss = new MiniBoss(new Image(getClass().getResource("/Cuphead/Images/Flappy Birds/Yellow/Fly/0.png").toExternalForm()));
//                    anchorPane.getChildren().add(miniBoss);
//                    miniBossAttack = false;
//                }
//            }
//        });
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                plane.requestFocus();
            }
        });
    }

    public void muteGame(MouseEvent mouseEvent) {
        if (muted == false) {
            App.muteMediaPlayer();
            muted = true;
            muteIcon.setImage(new Image(getClass().getResource("/Cuphead/Images/mute.png").toExternalForm()));
        } else {
            App.unmuteMediaPlayer();
            muted = false;
            muteIcon.setImage(new Image(getClass().getResource("/Cuphead/Images/unmute.png").toExternalForm()));
        }
    }

    private void fadePlane(){
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setNode(plane);
        fadeTransition.setCycleCount(1);
        fadeTransition.setDuration(Duration.millis(1000));
        fadeTransition.setFromValue(10);
        fadeTransition.setToValue(0.1);
        faded = true;
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
                faded = false;
            }
        });
    }

    private void addChildren(){
        anchorPane.getChildren().remove(fireMode);
        anchorPane.getChildren().remove(muteIcon);
        anchorPane.getChildren().add(background1);
        anchorPane.getChildren().add(background2);
        anchorPane.getChildren().add(background3);
        anchorPane.getChildren().add(fireMode);
        anchorPane.getChildren().add(muteIcon);
        anchorPane.getChildren().add(avatar);
        controller.setCurrentBoss(boss);
        anchorPane.getChildren().add(bossHouse);
        anchorPane.getChildren().add(bossHead);
        anchorPane.getChildren().add(plane);
        anchorPane.getChildren().add(scoreText);
        anchorPane.getChildren().add(hpText);
        anchorPane.getChildren().add(rocketProgressbar);
        anchorPane.getChildren().add(bossHpText);
        anchorPane.getChildren().add(bossHpProgressBar);
        anchorPane.getChildren().add(timeText);
    }

    private void startTransitions(){
        timerTransition = new TimerTransition(timeText);
        timerTransition.play();
        bossHpProgressbarTransition = new BossHpProgressbarTransition(bossHpProgressBar);
        bossHpProgressbarTransition.play();
        bossHpTransition = new BossHpTransition(bossHpText);
        bossHpTransition.play();
        rocketProgressbarTransition = new RocketProgressbarTransition(rocketProgressbar);
        rocketProgressbarTransition.play();
        scoreTextTransition = new ScoreTextTransition(scoreText);
        scoreTextTransition.play();
        userHpTransition = new UserHpTransition(hpText);
        userHpTransition.play();
        idleTransition = new IdleTransition(plane);
        idleTransition.play();
        BossHouseTransition bossHouseTransition = new BossHouseTransition(bossHouse);
        bossHouseTransition.play();
        BossHeadTransition bossHeadTransition = new BossHeadTransition(bossHead, anchorPane, bossHouse);
        bossHeadTransition.play();
        bossHeadTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                anchorPane.getChildren().remove(bossHead);
            }
        });
    }

    private void makeNodes(){
        timeText = new Text("0:0");
        timeText.setFont(new Font(30));
        timeText.setX(1100);
        timeText.setY(650);
        bossHpText = new Text();
        bossHpText.setText("Boss HP: 50");
        bossHpText.setX(1100);
        bossHpText.setY(100);
        bossHpText.setFont(new Font(20));
        bossHpProgressBar = new ProgressBar(0);
        bossHpProgressBar.setTranslateX(1100);
        bossHpProgressBar.setTranslateY(600);
        rocketProgressbar = new ProgressBar(0);
        rocketProgressbar.setTranslateX(200);
        rocketProgressbar.setTranslateY(680);
        scoreText = new Text("ُScore: 0");
        scoreText.setX(630);
        scoreText.setY(20);
        scoreText.setFont(new Font(20));
        scoreText.setFill(new Color(0, 0, 0, 1));
        hpText = new Text("HP: 0");
        hpText.setX(80);
        hpText.setY(650);
        hpText.setFont(new Font(15));
        hpText.setFill(new Color(0, 0, 0, 1));
        background1 = new ImageView(new Image(getClass().getResource("/Cuphead/Images/Background/7.png").toExternalForm()));
        background2 = new ImageView(new Image(getClass().getResource("/Cuphead/Images/Background/3.png").toExternalForm()));
        background3 = new ImageView(new Image(getClass().getResource("/Cuphead/Images/Background/2.png").toExternalForm()));
        background1.setFitWidth(1280);
        background1.setFitHeight(720);
        background2.setFitWidth(6400);
        background2.setFitHeight(200);
        background2.setY(520);
        background3.setFitHeight(1280);
        background3.setFitHeight(100);
        backgroundTransition = new BackgroundTransition(background2, background3);
        backgroundTransition.play();
        if (!muted)
            muteIcon.setImage(new Image(getClass().getResource("/Cuphead/Images/unmute.png").toExternalForm()));
        else
            muteIcon.setImage(new Image(getClass().getResource("/Cuphead/Images/mute.png").toExternalForm()));
        fireMode.setImage(new Image(getClass().getResource("/Cuphead/Images/Bullet/Icon.png").toExternalForm()));
        Image image = new Image(getClass().getResource("/Cuphead/Images/plane.png").toExternalForm());
        plane.setImage(image);
        anchorPane.getChildren().remove(plane);
        bossHead = new BossHead(new Image(getClass().getResource("/Cuphead/Images/Head/Idle/0.png").toExternalForm()));
        bossHouse = new BossHouse(new Image(getClass().getResource("/Cuphead/Images/House/0.png").toExternalForm()));
        boss = new Boss(bossHead, bossHouse);
        avatar = new ImageView(new Image(getClass().getResource("/Cuphead/Images/Avatar/" +
                GameController.getCurrentUser().getAvatar() + ".png").toExternalForm()));
        avatar.setX(1200);
        avatar.setY(20);
        avatar.setFitWidth(50);
        avatar.setFitHeight(50);
    }

    private void youLose(){
        Text text= new Text("You Lose");
        text.setFont(new Font(100));
        text.setX(600);
        text.setY(300);
        anchorPane.getChildren().add(text);
        WinTransition winTransition = new WinTransition(text);
        winTransition.play();
        winTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
    }
}
