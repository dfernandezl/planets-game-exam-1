package com.drpicox.game.runners;

import com.drpicox.game.commands.CommandController;
import com.drpicox.game.entities.Entity;
import com.drpicox.game.messages.MessageController;
import com.drpicox.game.players.Player;
import com.drpicox.game.satellite.SatelliteController;
import com.drpicox.game.ships.ShipController;
import com.drpicox.game.stars.Star;
import com.drpicox.game.stars.StarController;
import org.springframework.stereotype.Component;

@Component
public class CR501StarBuildSatellite implements CommandRunner {

    private CommandController commandController;
    private ShipController shipController;
    private MessageController messageController;
    private StarController starController;
    private SatelliteController satelliteController;

    public CR501StarBuildSatellite(CommandController commandController, ShipController shipController, MessageController messageController, StarController starController, SatelliteController satelliteController) {
        this.commandController = commandController;
        this.shipController = shipController;
        this.messageController = messageController;
        this.starController = starController;
        this.satelliteController = satelliteController;
    }

    @Override
    public int getPriority() {
        return 501;
    }

    @Override
    public void run() {
        var commands = commandController.listAllByType("BuildSatellite");

        for (var command : commands) {
            var player = command.getPlayer();
            var entity = command.getEntity();
            var name = command.getValue();
            buildSatellite(player, entity, name);
        }
    }

    private void buildSatellite(Player player, Entity entity, String name) {
        var star = (Star) entity;

        var hasMinerals = starController.consumeMinerals(star,7);
        if (hasMinerals) {
            starController.boostPopulation(star);
            satelliteController.createSatellite(player, name, star.getCoordinates());
        }
    }
}
