package com.drpicox.game.entities;

import com.drpicox.game.players.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface EntityRepository extends JpaRepository<Entity, Long> {

    // https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html#d0e1576
    List<Entity> findAllByPlayer(Player player);

    List<Entity> findAllByCoordinatesIn(Collection<Coordinates> coordinatesList);

}
