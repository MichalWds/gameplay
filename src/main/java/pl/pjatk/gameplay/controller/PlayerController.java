package pl.pjatk.gameplay.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.gameplay.model.Player;
import pl.pjatk.gameplay.service.DamageService;
import pl.pjatk.gameplay.service.PlayerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private PlayerService playerService;
    private DamageService damageService;

    public PlayerController(PlayerService playerService, DamageService damageService) {
        this.playerService = playerService;
        this.damageService = damageService;
    }

    @GetMapping
    public ResponseEntity<List<Player>> findAll() {
        return ResponseEntity.ok(playerService.findAll());
    }

    @GetMapping("/test")
    public ResponseEntity<String> findString() {
        return ResponseEntity.ok("Hello");
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Player>> findById(@PathVariable long id) {
        Optional<Player> byId = playerService.findById(id);
        if (byId.isPresent()) {
            return ResponseEntity.ok(byId);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<Player> save(@RequestBody Player player, @PathVariable long id) {
        return ResponseEntity.ok(playerService.save(player));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> update(@RequestBody Player playerWithUpdatedProperties, Long id) {
        return ResponseEntity.ok(playerService.update(playerWithUpdatedProperties, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        playerService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{idD}/{idA}")
    public ResponseEntity<Optional<Player>> update(@PathVariable long idA, @PathVariable long idD) {
        return ResponseEntity.ok(damageService.update(idA, idD));
    }

//    @GetMapping("health/{health}")
//    public ResponseEntity<Optional<Player>> findById(@PathVariable long id) {
//        Optional<Player> byId = playerService.findById(id);
//        if (byId.isPresent()) {
//            return ResponseEntity.ok(byId);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }


}
