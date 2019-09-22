package com.drpicox.game.runners;

import com.drpicox.game.commands.CommandController;
import com.drpicox.game.entities.Entity;
import com.drpicox.game.messages.MessageController;
import com.drpicox.game.players.Player;
import com.drpicox.game.ships.ShipController;
import com.drpicox.game.stars.Star;
import com.drpicox.game.stars.StarController;
import org.springframework.stereotype.Component;

@Component
public class CR501StarBuildShip implements CommandRunner {

    private CommandController commandController;
    private ShipController shipController;
    private MessageController messageController;
    private StarController starController;

    public CR501StarBuildShip(CommandController commandController, ShipController shipController, MessageController messageController, StarController starController) {
        this.commandController = commandController;
        this.shipController = shipController;
        this.messageController = messageController;
        this.starController = starController;
    }

    @Override
    public int getPriority() {
        return 501;
    }

    @Override
    public void run() {
        var commands = commandController.listAllByType("BuildShip");

        for (var command : commands) {
            var player = command.getPlayer();
            var entity = command.getEntity();
            var name = command.getValue();
            buildShip(player, entity, name);
        }
    }

    private void buildShip(Player player, Entity entity, String name) {
        if (!(entity instanceof Star)) return;
        var star = (Star) entity;
        var coordinates = entity.getCoordinates();

        var hasMinerals = starController.consumeMinerals(star,5);
        if (hasMinerals) {
            shipController.createShip(player, name, coordinates, 100);
            messageController.sendMessage(player, "Created the " + name + " ship", coordinates);
        } else {
            messageController.sendMessage(player, "Cannot build ship " + name + " due to a lack of available minerals", coordinates);
        }
    }
}
