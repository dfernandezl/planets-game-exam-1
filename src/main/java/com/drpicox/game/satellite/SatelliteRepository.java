package com.drpicox.game.satellite;

import com.drpicox.game.entities.Coordinates;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SatelliteRepository extends JpaRepository<Satellite, Long> {

    List<Satellite> findAllByCoordinates(Coordinates coordinates);

}
