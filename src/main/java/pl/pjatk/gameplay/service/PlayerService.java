package pl.pjatk.gameplay.service;

import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.model.Player;

import java.util.List;

@Service
public class PlayerService {

    public List<Player> findAll() {
        return List.of(new Player(4, "dupa", 400, 200, 500),
                new Player());
    }
}

