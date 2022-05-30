package Cuphead.Model;


import java.util.ArrayList;
import java.util.Random;

public class User{
    private String username;
    private String password;
    private static ArrayList<User> allUsers = new ArrayList<>();
    private int avatar = 0;
    private int score;
    private int HP = 5;
    private int damageMultiplier = 2;
    private int damageTaken = 2;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        Random random = new Random(System.currentTimeMillis());
        this.avatar = random.nextInt(5);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public int getHP() {
        return HP;
    }

    public int getAvatar() {
        return avatar;
    }

    public int getScore() {
        return score;
    }

    public int getDamageMultiplier() {
        return damageMultiplier;
    }

    public int getDamageTaken() {
        return damageTaken;
    }

    //setters

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setDamageMultiplier(int damageMultiplier) {
        this.damageMultiplier = damageMultiplier;
    }

    public void setDamageTaken(int damageTaken) {
        this.damageTaken = damageTaken;
    }
}
