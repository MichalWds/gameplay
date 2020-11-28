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

//    public Optional<Player> findById(int id) {
//        List<Player> players = new ArrayList<>();
//        players.add(new Player(5L, "okon", 500, 500, 330));
//        players.add(new Player(3L, "dpa", 200, 500, 330));
//
//        return players.stream()
//                .filter(player -> player.getId() == id)
//                .findFirst();
//    }

    public Optional<Player> findById(Long id) {
        if (id == 10) {
            throw new IllegalArgumentException("abc");
        } else {
            return playerRepository.findById(id);
        }
    }

//
//    public Optional<Player> findById(Long id) {
//        return playerRepository.findById(id);
//    }

    public void delete(Long id) {
        playerRepository.deleteById(id);
    }

    public Player update(Player playerWithUpdatedProperties, Long id) {
        playerWithUpdatedProperties.setId(id);
        return playerRepository.save(playerWithUpdatedProperties);
    }
}

