package com.drpicox.game.ships;

import com.drpicox.game.entities.Coordinates;
import com.drpicox.game.entities.EntityController;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShipController {

    private ShipRepository shipRepository;

    public ShipController(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    public List<Ship> listAllByCoordinates(Coordinates coordinates) {
        return shipRepository.findAllByCoordinates(coordinates);
    }

    public void createShip(Player player, String name, Coordinates coordinates, int size) {
        shipRepository.save(new Ship(player, name, coordinates, size));
    }

    public void moveShip(Ship ship, Coordinates coordinates) {
        ship.moveEntity(coordinates);
        shipRepository.save(ship);
    }

    public void loadPopulation(Ship ship, int amount) {
        ship.loadPopulation(amount);
        shipRepository.save(ship);
    }

    public void refuel(Ship ship, int amount) {
        ship.refuel(amount);
        shipRepository.save(ship);
    }
}
