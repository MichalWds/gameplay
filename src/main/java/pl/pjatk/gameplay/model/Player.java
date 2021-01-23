package pl.pjatk.gameplay.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private int health;
    private int attack;
    private int mana;
    private int money;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL) //umozliwia wykonywanie na wlasna reke cascady, czyli np przypisz message do playera (cascade, typ operacji na ktora pozwalamy w relacji
    private List<Message> messageList = new ArrayList<>(); //inicjalizacja jest potrzebna bo moze rzucac nullPointerami

    public Player() {
    }

    public Player(Long id, String nickname, int health, int attack, int mana, int money, List<Message> messageList) {
        this.id = id;
        this.nickname = nickname;
        this.health = health;
        this.attack = attack;
        this.mana = mana;
        this.money = money;
        this.messageList = messageList;
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

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }
}
