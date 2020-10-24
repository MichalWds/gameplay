package pl.pjatk.gameplay.service;

import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.model.Player;
import pl.pjatk.gameplay.repository.PlayerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player save(Player player) {
        return playerRepository.save(player);
    }

    private List<Player> players = List.of(new Player(1L, "DDD2 ", 303, 23, 140),
            new Player(2L, "John", 23, 30, 334));

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public Optional<Player> findById(int id) {
        List<Player> players = new ArrayList<>();
        players.add(new Player(5L, "okon", 500, 500, 330));
        players.add(new Player(3L, "dpa", 200, 500, 330));

        return players.stream()
                .filter(player -> player.getId() == id)
                .findFirst();
    }
}

