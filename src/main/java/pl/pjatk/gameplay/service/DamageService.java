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

    public Optional<Player> update (long idA, long idD){
        playerRepository.findById(idA);
        playerRepository.findById(idD);
        System.out.println(playerRepository.findById(idD).get().getHealth() + " zycie poczatkowe");

        if (playerRepository.findById(idA).isPresent() && playerRepository.findById(idD).isPresent()) {
            playerRepository.findById(idD).get()
                    .setHealth(playerRepository.findById(idD).get().getHealth()
                            - playerRepository.findById(idA).get().getAttack());

            System.out.println(playerRepository.findById(idD).get().getHealth()+ "zycie koncowe");
            ;
        }
        return playerRepository.findById(idD);
    }
}
