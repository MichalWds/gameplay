package pl.pjatk.gameplay.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.pjatk.gameplay.model.Player;
import pl.pjatk.gameplay.repository.PlayerRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PlayerServiceTestIT {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private PlayerRepository playerRepository;

    @BeforeEach
    public void clean(){
        playerService.deleteAll();
    }

    @Test
    void playerListShouldBeEmpty() {

        List<Player> playerList = playerService.findAll();
        assertThat(playerList).isEmpty();
    }

    @Test
    void shouldAddPlayerToDB() {

        Player player = new Player("adas", 500, 30, 40, 40);
        Player savePlayer = playerService.save(player);
        assertThat(savePlayer.getId()).isNotNull();
    }

    @Test
    void playerListShouldNotBeEmpty() {

        List<Player> playerList = playerService.findAll();
        Player player = new Player("MarcinLuter", 500, 30, 40, 40);
        playerList.add(player);
        assertThat(playerList).isNotEmpty();
    }

    @Test
    void findByIdReturnCorrectPlayer() {

        Player player = new Player("adas", 500, 30, 40, 40);
        playerService.save(player);

        Optional<Player> byId = playerRepository.findById(player.getId());
        assertThat(byId.isPresent()).isTrue();
    }

    @Test
    void findByIdThrowException() {
        Player player = new Player("dadas", 100, 10, 10,30);
        playerService.save(player);
     //   assertThrows(RuntimeException.class,()->playerService.findById(10L));
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> playerService.findById(10L));
    }

    @Test
    void shouldAttack(){
        Player att = new Player("adas", 500, 30, 40, 40);
        Player def = new Player("adas2", 500, 30, 40, 40);

        Player saveOne = playerService.save(att);
        Player saveTwo = playerService.save(def);

        playerService.attack(saveOne.getId(), saveTwo.getId());

        assertThat(playerService.findById(saveTwo.getId()).get().getHealth()).isEqualTo(470);
    }
}
