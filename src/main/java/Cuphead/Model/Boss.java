package Cuphead.Model;

public class Boss {
    private int HP = 50;
    private BossHead bossHead;
    private BossHouse bossHouse;

    public Boss(BossHead bossHead, BossHouse bossHouse) {
        this.bossHead = bossHead;
        this.bossHouse = bossHouse;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }
}
