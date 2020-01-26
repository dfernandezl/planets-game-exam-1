package com.drpicox.game.satellite;

import com.drpicox.game.entities.Coordinates;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SatelliteController {

    private SatelliteRepository satelliteRepository;

    public SatelliteController(SatelliteRepository satelliteRepository) {
        this.satelliteRepository = satelliteRepository;
    }

    public void createSatellite(Player player, String name, Coordinates coordinates) {
        satelliteRepository.save(new Satellite(player, name, coordinates));
    }

    public void upgradeLevel(Satellite satellite) {
        satellite.upgradeLevel();
        satelliteRepository.save(satellite);
    }
}
