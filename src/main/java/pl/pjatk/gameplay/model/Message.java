package pl.pjatk.gameplay.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //automatycznie id 1 player do id 1 message
    private int id;
    private String content;

    @ManyToOne
    @JoinColumn(name ="player_id") //lacz w bazie tabele o tym samym id
    @JsonIgnore //zapobiega rekurencji, lista w liscie itd
    private Player player;

    public Message() {
    }

    public Message(String content, Player player) {
        this.content = content;
        this.player = player;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
