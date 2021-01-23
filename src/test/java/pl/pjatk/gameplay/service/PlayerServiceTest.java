package pl.pjatk.gameplay.service;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pjatk.gameplay.model.Player;
import pl.pjatk.gameplay.repository.PlayerRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayerServiceTest {

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerService playerService;

    @Mock
    private Player player;

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Before all");
    }

    @BeforeEach
    public void beforeEach (){
        System.out.println("Before each");
        playerRepository.save(new Player());
    }

    @AfterEach
    public void afterEach (){
        System.out.println("After each");
        playerRepository.deleteAll();
    }

    @Test
    public void testFindAll() {

        when(playerRepository.findAll()).thenReturn(List.of(new Player()));

        List<Player> allPlayers = playerService.findAll();

        assertThat(allPlayers).isNotEmpty();
    }

    @Test
    public void testFindById(){

        when(playerRepository.findById(3L)).thenReturn(Optional.of(new Player()));

        Optional<Player> player3 = playerService.findById(3L);

        assertThat(player3).isNotEmpty();
    }

    @Test
    public void testSave(){

        Player player1 = new Player("test",200,300,400,500);
        Player player2 = new Player(3L,"test",200,300,400,500, List.of());

        when(playerRepository.save(player1)).thenReturn(player2);

        Player player = playerService.save(player1);

        assertThat(player.getId()).isEqualTo(3L);
    }

    @Test
    public void shouldDelete(){

        playerService.deleteById(1L);

        verify(playerRepository, atLeastOnce()).deleteById(1L);
    }
    //todo zrobic update
    @Test
    public void testUpdate(){

        Player player1 = new Player("test",200,300,400,500);
        Player player2 = new Player(3L,"test",200,300,400,500, List.of());

        when(playerRepository.save(player1)).thenReturn(player2);

        Player player = playerService.update(player1, 1L);

        assertThat(player.getId()).isEqualTo(2L);





    }


}
