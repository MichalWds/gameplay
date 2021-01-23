package pl.pjatk.gameplay.service;

import org.springframework.stereotype.Service;
import pl.pjatk.gameplay.model.Player;
import pl.pjatk.gameplay.repository.PlayerRepository;

import java.util.Optional;

@Service
public class DamageService {

    private PlayerRepository playerRepository;

    public DamageService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }
//remove if want to use PutMapping with two id's. After that DamageService will stop working without injection
    public DamageService() {

    }

    public Optional<Player> update(long idA, long idD) {
        playerRepository.findById(idA);
        playerRepository.findById(idD);
        System.out.println(playerRepository.findById(idD).get().getHealth() + " zycie poczatkowe");

        if (playerRepository.findById(idA).isPresent() && playerRepository.findById(idD).isPresent()) {
            playerRepository.findById(idD).get()
                    .setHealth(playerRepository.findById(idD).get().getHealth()
                            - playerRepository.findById(idA).get().getAttack());

            System.out.println(playerRepository.findById(idD).get().getHealth() + "zycie koncowe");
        }
        return playerRepository.findById(idD);
    }

    public Player heal(Player player) {

        player.setMana(player.getMana() - 200);
        player.setHealth(player.getHealth() + 200);

        return player;
    }

    public Player recoverMana(Player player) {

        player.setMana(player.getMana() + 200);
        player.setMoney(player.getMoney() - 400);

        return player;
    }

    public Player increaseAttack(Player player) {

        if (player.getMana() > 300) {

            player.setAttack(player.getAttack() + 200);
            player.setMana(player.getMana() - 300);
        } else {
            return player;
        }
        return player;
    }

    public Player attack(Player attacker, Player defender) {
        defender.setHealth(defender.getHealth() - attacker.getAttack());
        return defender;
    }
}
