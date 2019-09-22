package com.drpicox.game.messages;

import com.drpicox.game.entities.Coordinates;
import com.drpicox.game.players.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    // https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html#d0e1576
    List<Message> findAllByPlayer(Player player);

}
