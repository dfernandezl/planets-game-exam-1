package com.drpicox.game.runners;

import com.drpicox.game.commands.CommandController;
import com.drpicox.game.entities.Coordinates;
import com.drpicox.game.messages.MessageController;
import com.drpicox.game.ships.Ship;
import com.drpicox.game.ships.ShipController;
import com.drpicox.game.starbases.Starbase;
import com.drpicox.game.starbases.StarbaseController;
import com.drpicox.game.stars.Star;
import com.drpicox.game.stars.StarController;
import org.springframework.stereotype.Component;

import static java.lang.Math.min;

@Component
public class CR200RefuelShips implements CommandRunner {

    private CommandController commandController;
    private ShipController shipController;
    private StarbaseController starbaseController;

    public CR200RefuelShips(CommandController commandController, ShipController shipController, StarbaseController starbaseController) {
        this.commandController = commandController;
        this.shipController = shipController;
        this.starbaseController = starbaseController;
    }

    @Override
    public int getPriority() {
        return 200;
    }

    @Override
    public void run() {
        var starbases = starbaseController.listAll();

        starbases.forEach(this::refillStarbaseShips);
    }

    private void refillStarbaseShips(Starbase starbase) {
        var coordinates = starbase.getCoordinates();
        var ships = shipController.listAllByCoordinates(coordinates);

        ships.stream()
                .filter(ship -> ship.getPlayer().equals(starbase.getPlayer()))
                .forEach(ship -> refuelShip(ship, starbase));
    }

    private void refuelShip(Ship ship, Starbase starbase) {
        var limitShip = ship.getMissingFuel();
        var limitStarbase = starbase.getFuel();

        var amount = min(limitShip, limitStarbase);
        if (amount > 0) {
            starbaseController.consumeFuel(starbase, amount);
            shipController.refuel(ship, amount);
        }
    }

}
