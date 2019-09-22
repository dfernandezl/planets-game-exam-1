package com.drpicox.game.stars;

import com.drpicox.game.entities.Coordinates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StarRepository extends JpaRepository<Star, Long> {

    Star findByCoordinates(Coordinates coordinates);
}
