package pl.pjatk.gameplay.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Player {

    @Id
    @GeneratedValue
    private Long id;
    private String nickname;
    private int health;
    private int attack;
    private int mana;
    private int money;

    public Player() {
    }

    public Player(Long id, String nickname, int health, int attack, int mana, int money) {
        this.id = id;
        this.nickname = nickname;
        this.health = health;
        this.attack = attack;
        this.mana = mana;
        this.money = money;
    }

    public Player(String nickname, int health, int attack, int mana, int money){
        this.nickname = nickname;
        this.health = health;
        this.attack = attack;
        this.mana = mana;
        this.money = money;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
