package com.drpicox.game.ships;

import com.drpicox.game.entities.Coordinates;
import com.drpicox.game.entities.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface ShipRepository extends JpaRepository<Ship, Long> {

    List<Ship> findAllByCoordinates(Coordinates coordinates);

}
