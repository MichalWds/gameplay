//package pl.pjatk.gameplay.service;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import pl.pjatk.gameplay.model.Player;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class DamageServiceTest {
//
//    @InjectMocks
//    private final DamageService damageService;
//
//    public DamageServiceTest() {
//        damageService = new DamageService();
//    }
//
//    @Test
//    public void testHealWithoutProblems() {
//
//        //given
//        Player player = new Player();
//        player.setHealth(200);
//        player.setMana(300);
//
//        //when
//        damageService.heal(player);
//        //then
//        assertThat(player.getHealth()).isEqualTo(400);
//        assertThat(player.getMana()).isLessThan(300);
//    }
//
//    @Test
//    public void testHealCheckMana() {
//
//        //given
//        Player player = new Player();
//        player.setHealth(200);
//        player.setMana(300);
//
//        //when
//        damageService.heal(player);
//        //then
//        assertThat(player.getMana()).isLessThan(300);
//    }
//
//    @Test
//    public void testRecoverManaWithoutProblems() {
//
//        //given
//        Player player = new Player();
//        player.setMana(400);
//        player.setMoney(500);
//
//        //when
//        damageService.recoverMana(player);
//        //then
//        assertThat(player.getMana()).isGreaterThan(400);
//    }
//
//    @Test
//    public void testRecoverManaCheckWallet() {
//
//        //given
//        Player player = new Player();
//        player.setMana(400);
//        player.setMoney(500);
//
//        //when
//        damageService.recoverMana(player);
//        //then
//        assertThat(player.getMoney()).isEqualTo(100);
//    }
//
//    @Test
//    public void testIncreaseAttackWithoutProblems() {
//
//        //given
//        Player player = new Player();
//        player.setMana(400);
//        player.setAttack(300);
//
//        //when
//        damageService.increaseAttack(player);
//        //then
//        assertThat(player.getAttack()).isGreaterThan(300);
//        assertThat(player.getMana()).isEqualTo(100);
//    }
//
//    @Test
//    public void testIncreaseAttackNotPossible() {
//
//        //given
//        Player player = new Player();
//        player.setMana(200);
//        player.setAttack(300);
//
//        //when
//        damageService.increaseAttack(player);
//        //then
//        assertThat(player.getAttack()).isEqualTo(300);
//        assertThat(player.getMana()).isEqualTo(200);
//    }
//
//    @Test
//    public void test() {
//
//        //given
//        Player player = new Player();
//        player.setMana(400);
//        player.setAttack(300);
//
//        //when
//        damageService.increaseAttack(player);
//        //then
//        assertThat(player.getAttack()).isGreaterThan(300);
//        assertThat(player.getMana()).isEqualTo(100);
//    }
//}
