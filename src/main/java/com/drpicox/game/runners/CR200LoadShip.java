package com.drpicox.game.runners;

import com.drpicox.game.commands.CommandController;
import com.drpicox.game.entities.Coordinates;
import com.drpicox.game.messages.MessageController;
import com.drpicox.game.players.Player;
import com.drpicox.game.ships.Ship;
import com.drpicox.game.ships.ShipController;
import com.drpicox.game.stars.Star;
import com.drpicox.game.stars.StarController;
import org.springframework.stereotype.Component;

import static java.lang.Math.min;

@Component
public class CR200LoadShip implements CommandRunner {

    private CommandController commandController;
    private StarController starController;
    private ShipController shipController;
    private MessageController messageController;

    public CR200LoadShip(CommandController commandController, StarController starController, ShipController shipController, MessageController messageController) {
        this.commandController = commandController;
        this.starController = starController;
        this.shipController = shipController;
        this.messageController = messageController;
    }

    @Override
    public int getPriority() {
        return 200;
    }

    @Override
    public void run() {
        var commands = commandController.listAllByType("LoadShip");

        for (var command : commands) {
            var player = command.getPlayer();
            var ship = (Ship) command.getEntity();
            var amount = Integer.parseInt(command.getValue());
            var coordinates = ship.getCoordinates();
            var star = starController.getStar(coordinates);

            decideAction(player, ship, amount, coordinates, star);
        }
    }

    private void decideAction(Player player, Ship ship, int amount, Coordinates coordinates, Star star) {
        if (star == null) {
            if (amount > 0) messageController.sendMessage(player, "Cannot load the " + ship.getName() + " ship from an empty space", coordinates);
            else messageController.sendMessage(player, "Cannot unload the " + ship.getName() + " ship into an empty space", coordinates);
            return;
        }

        var starPlayer = star.getPlayer();
        if (starPlayer == null || !starPlayer.equals(player)) {
            if (amount > 0) messageController.sendMessage(player, "Cannot load the " + ship.getName() + " ship from an alien planet", coordinates);
            if (amount < 0) conquerStar(-amount, ship, star, coordinates);
            return;
        }

        if (amount > 0) loadShip(amount, ship, star, coordinates);
        else unloadShip(-amount, ship, star, coordinates);
    }

    private void loadShip(int amount, Ship ship, Star star, Coordinates coordinates) {
        var shipLimit = ship.getMaxPopulation() - ship.getPopulation();
        var starLimit = star.getPopulation();
        var real = min(amount, min(shipLimit, starLimit));

        starController.extractPopulation(star, real);
        shipController.loadPopulation(ship, real);
        if (real != amount) messageController.sendMessage(ship.getPlayer(), "Loaded " + real + " of " + amount + " to the " + ship.getName() + " ship", coordinates);
    }

    private void unloadShip(int amount, Ship ship, Star star, Coordinates coordinates) {
        var shipLimit = ship.getPopulation();
        var starLimit = star.getMaxPopulation() - star.getPopulation();
        var real = min(amount, min(shipLimit, starLimit));

        starController.extractPopulation(star, -real);
        shipController.loadPopulation(ship, -real);
        if (real != amount) messageController.sendMessage(ship.getPlayer(), "Unloaded " + real + " of " + amount + " from the " + ship.getName() + " ship", coordinates);
    }

    private void conquerStar(int amount, Ship ship, Star star, Coordinates coordinates) {
        var shipLimit = ship.getPopulation();
        var starLimit = star.getMaxPopulation();
        var real = min(amount, min(shipLimit, starLimit));

        var shipPlayer = ship.getPlayer();
        var starPlayer = star.getPlayer();
        var shipDamage = shipPlayer.getRace().getDamage();
        var starDamage = starPlayer != null ? starPlayer.getRace().getDamage() : 1.0;
        var shipPoints = real * shipDamage;
        var starPoints = star.getPopulation() * starDamage;

        var finalPoints = shipPoints - starPoints;
        shipController.loadPopulation(ship, -real);
        if (finalPoints > 0) {
            var survivors = (int) (finalPoints / shipDamage);
            starController.looseBattle(star, ship.getPlayer(), survivors);
            messageController.sendMessage(shipPlayer, "Star " + star.getName() + " conquered!", coordinates);
        } else {
            var survivors = (int) (-finalPoints / starDamage);
            starController.winsBattle(star, survivors);
            messageController.sendMessage(shipPlayer, "Star " + star.getName() + " resisted.", coordinates);
        }
    }

}
