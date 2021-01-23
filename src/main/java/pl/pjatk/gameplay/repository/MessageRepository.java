package pl.pjatk.gameplay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.gameplay.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
