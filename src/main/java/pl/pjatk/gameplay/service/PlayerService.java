package pl.pjatk.gameplay.service;

import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.model.Player;
import pl.pjatk.gameplay.repository.PlayerRepository;

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

    private List<Player> players = List.of(new Player(1L, "DDD2 ", 303, 23, 140,1000),
            new Player(2L, "John", 23, 30, 334, 800),
            new Player(3L, "Joshn", 23, 30, 334,700),
            new Player(3L, "Jos2hn", 233, 320, 34,1000));

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public Optional<Player> findById(Long id) {
        if (id == 10) {
            throw new IllegalArgumentException("abc");
        } else {
            return playerRepository.findById(id);
        }
    }

    public void deleteById(Long id) {
        playerRepository.deleteById(id);
    }

    public Player update(Player playerWithUpdatedProperties, Long id) {
        playerWithUpdatedProperties.setId(id);
        return playerRepository.save(playerWithUpdatedProperties);
    }
}

